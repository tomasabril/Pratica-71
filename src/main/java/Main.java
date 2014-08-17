
import java.util.*;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná DAINF - Departamento
 * Acadêmico de Informática IF62C - Fundamentos de Programação 2
 *
 * @author Tomás Abril
 */
public class Main {

	public static void main(String[] args) {

		ArrayList<Jogador> time = new ArrayList<>();
		Scanner input = new Scanner(System.in);

		System.out.println("Quantos Jogadores?");
		int num = input.nextInt();
		int numero = 1;
		String nome;
		int posicao;
		JogadorComparator comparador = new JogadorComparator(true, false);
		for (int i = 0; i < num; i++) {
			System.out.println("Numero do jogador " + (i + 1) + ":");
			numero = input.nextInt();
			System.out.println("Nome   do jogador " + (i + 1) + ":");
			nome = input.next();
			time.add(new Jogador(numero, nome));
		}
		while (numero != 0) {
			Collections.sort(time, comparador);
			String format = "%3d %-20s";
			System.out.println("Num  Nome");
			for (Jogador i : time) {
				System.out.println(String.format(format, i.numero, i.nome));
			}

			System.out.println("Numero do jogador extra: ");
			numero = input.nextInt();
			System.out.println("Nome   do jogador extra: ");
			nome = input.next();
			if (numero == 0) {
				break;
			}
			posicao = Collections.binarySearch(time, new Jogador(numero, nome), comparador);
			if (posicao >= 0) {
				time.set(posicao, new Jogador(numero, nome));
			} else {
				time.add(new Jogador(numero, nome));
			}
		}
	}
}
