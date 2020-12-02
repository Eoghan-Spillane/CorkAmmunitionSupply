package ServerController;



public class Server {
    private static SocketServer socketServerBase = new SocketServer();
    static OutpostController outposts = socketServerBase.getOutpost();


    public static void main(String[] args) {
            outposts.createObserver();

            Thread socketServer = new Thread((Runnable) socketServerBase);
            socketServer.start();
    }

    public static void restartSocketServer(){
        Thread socketServer = new Thread((Runnable) socketServerBase);
        socketServer.start();
    }

}
