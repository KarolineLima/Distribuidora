package dao;
 
import java.util.List;
import java.util.TreeMap;

import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ClientConfiguration;
import com.db4o.events.CancellableObjectEventArgs;
import com.db4o.events.CommitEventArgs;
import com.db4o.events.Event4;
import com.db4o.events.EventListener4;
import com.db4o.events.EventRegistry;
import com.db4o.events.EventRegistryFactory;
import com.db4o.events.ObjectContainerEventArgs;

public class IDControle {
    // Faz a geração automatica de IDs para qualquer classe que implementa
    // a interface IDInterface
    protected static ObjectContainer manager;
    protected static ObjectContainer managersequencia;
    private static boolean gerounovoid;
    private static boolean bancolocal;  
    private static String ipservidor;
    private static TreeMap<String,RegistroID> registros = new TreeMap<String,RegistroID>();
 
 
    public static void registrarManager(ObjectContainer man){
        manager = man;
        bancolocal = manager instanceof EmbeddedObjectContainer;
        EventRegistry eventRegistry = EventRegistryFactory.forObjectContainer(manager);
 
        if(bancolocal) {
            EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration(); 
            config.common().messageLevel(0);  // 0,1,2,3...
            managersequencia = Db4oEmbedded.openFile(config, "sequencia.db4o");
        }
        else {
            ClientConfiguration config = Db4oClientServer.newClientConfiguration( ) ;
            config.common().messageLevel(0);   //0,1,2,3,4
            managersequencia = Db4oClientServer.openClient(config,ipservidor,35000,"usuario1","senha1");    
        }
 
        //------------------------------------------
        // ADICIONAR OUVINTE DE EVENTOS DO BANCO DE DADOS
        //------------------------------------------
        // evento gerado antes de persistir um objeto
        eventRegistry.creating().addListener(new EventListener4<CancellableObjectEventArgs>() {
            public void onEvent(Event4<CancellableObjectEventArgs> event4, CancellableObjectEventArgs args) {
 
                // verificar se o objeto persistido implementa a interface IDInterface
                Object objeto = args.object();
                if(objeto instanceof IDInterface){
                    String nomedaclasse = objeto.getClass().getName();
                    RegistroID registro = registros.get(nomedaclasse);
                    if(registro == null) {
                        List<RegistroID> resultados = managersequencia.queryByExample(new RegistroID(nomedaclasse));
                        if(resultados.size()==0)
                            registro = new RegistroID(nomedaclasse); // cria o registro para a classe
                        else {
                            registro = (RegistroID) resultados.get(0); // carrega o resistro da classe existente
                        }
                    }
                    registro.incrementarID();
                    registros.put(nomedaclasse, registro);
 
                    // inserir o novo id  no objeto que está sendo persistido
                    ((IDInterface) objeto).setId(registro.getid()); 
                     
                    gerounovoid = true;
                    //System.out.println("--->gerando id="+novoid+" para a classe="+nomedaclasse);
                }
            }
        });
 
        // evento gerado imediatamente antes do commit
        eventRegistry.committing().addListener(new EventListener4<CommitEventArgs>() {
            public  void onEvent(Event4<CommitEventArgs> source,CommitEventArgs arguments) {              //salvar os registros alterados no banco
                if (gerounovoid) {
                    gerounovoid = false;
                    for(RegistroID reg : registros.values()) {  //atualizar os registros no banco
                        managersequencia.store(reg);
                        managersequencia.commit();
                        if(!bancolocal) 
                            managersequencia.ext().purge(reg);      //excluir do cache 
                    }
 
                }
 
            }
        });   
 
        //evento de abertura do banco
//      eventRegistry.opened().addListener(new EventListener4<ObjectContainerEventArgs>() {
//          public void onEvent(Event4<ObjectContainerEventArgs> event, ObjectContainerEventArgs args) {
//              //---------
//          }
//      });
 
        //evento de fechamento do banco principal
        eventRegistry.closing().addListener(new EventListener4<ObjectContainerEventArgs>() {
            public void onEvent(Event4<ObjectContainerEventArgs> event, ObjectContainerEventArgs args) {
                if (managersequencia!= null && !managersequencia.ext().isClosed())
                    managersequencia.close();       //fecha o banco de sequencias
            }
        });
    }
     
    public static void registrarManager(ObjectContainer man, String ip){
        ipservidor = ip;
        registrarManager(man);
    }
     
 
}
//============================================================
class RegistroID{
    //armazena o nome da classe e o ultimo id desta classe
    //============================================================
    private String nomedaclasse;
    private int ultimoid;
    public RegistroID(String nomedaclasse) {
        this.nomedaclasse = nomedaclasse;
        this.ultimoid = 0;
    }       
    public int getid() {
        return ultimoid;
    }
    public void incrementarID() {
        ultimoid++;
    }
    public String getNomedaclasse() {
        return nomedaclasse;
    }
    public void setNomedaclasse(String nomedaclasse) {
        this.nomedaclasse = nomedaclasse;
    }
    @Override
    public String toString() {
        return "RegistroID [nomedaclasse=" + nomedaclasse + ", ultimoid=" + ultimoid + "]";
    }       
 
}