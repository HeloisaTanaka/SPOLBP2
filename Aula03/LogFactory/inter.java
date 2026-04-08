package Aula03.LogFactory;

interface Logger {
   void log(String msg);
}

class ConsoleLogger implements Logger{
    public void log(String msg) {
        System.out.println(msg);
    }
}

class FileLogger implements Logger {
    public void log(String msg) {
        System.out.println("Criando arquivo: " + msg);
    }
}

class LoggerFactory{
    public static Logger CriarLog(String tipo){
        if (tipo.equals("console")){
            return new ConsoleLogger();
        } else if (tipo.equals("file")) {
            return new FileLogger();
        }
        throw new IllegalArgumentException("Log desconhecido");
    }
}

public class Main{
    public static void main(String[] args) {
        Logger tela = LoggerFactory.
    }
}
