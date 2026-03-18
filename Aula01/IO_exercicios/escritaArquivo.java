import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

class escritaArquivo {
    public static void main(String[] args) {
        Path caminho = Path.of("Exercicio_1.txt");
        String conteudo = "Heloisa Lorencini Tanaka\nSP3148602";

        try {
            Files.writeString(caminho, conteudo);

            List<String> linhas = Files.readAllLines(caminho);
            for (String linha : linhas){
                System.out.println(linha);
            }

            Files.move(caminho, caminho.resolveSibling("Exercicio_1_rename.txt"));
        } catch (IOException e) {
            System.err.println("Erro ao gravar: " + e.getMessage());
        }
    }
    
}