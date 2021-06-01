import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;
import java.util.Random;

public class ProjectUltron {
	static Scanner input = new Scanner(System.in);
	static int acertos = 10, temp_dialog = 5, temp_narrativa = 150, capitulo = 1;
	static String nome;
	static int hpHacker = 100, corpoUltron = 0, avast = 3, defender = 5, restau = 3;

	static void TelaPorta(int[] p) {
		
		System.out.print("====================\n");
		for (int i = 0; i < p.length; i++) {

			System.out.print("[" + i + "]");

		}
		System.out.print("\n====================\n");

	}

	static void PortaAcesso() throws InterruptedException {
		boolean saida = true;
		int prt;
		int[][] portas = new int[3][3];
		ArrayList valor = new ArrayList();

		valor.add(0);
		valor.add(-1);
		valor.add(0);
		
		for (int j = 0; j < portas.length; j++) {

			Collections.shuffle(valor);

			for (int i = 0; i < portas[j].length; i++) {

				portas[j][i] = (int) valor.get(i);

			}

		}

		for (int j = 0; j < portas.length; j++) {

			System.out.println((j + 1) + "º Porta");

			do {

				TelaPorta(portas[j]);

				System.out.print("\nDigite o valor de uma das portas de acesso: ");
				prt = input.nextInt();

			} while (prt < 0 || prt > 2);

			for (int i = 0; i < portas[j].length; i++) {

				if (portas[j][prt] == -1) {

					Batalha(capitulo);
					saida = false;
					break;
				}

			}

			if (!saida)
				break;
			else if (j == 2)
				System.out.println("Siga adiante para o teste!");
			else
				System.out.println("\nPorta Livre, siga para a proxima porta.");

			System.out.println();
		}

	}

	static void IntrucoesBat() throws InterruptedException {
		int op = 0;
		do {

			System.out.println("O objetivo é diminuir o HP do adversário.");
			System.out.println("Para batalhar basta escolher uma das opções...");
			System.out.println("A cada opção há uma consequência.");
			System.out.println("Varredura = Gera um ataque que tira entre 0 - 25, o menor porém ilimitado.");
			System.out.println("Windows Defender = Gera um ataque que tira entre 0 - 50, porém uso limitado.");
			System.out
					.println("Restaurar o Computador = Cura 20% do HP, porém o seu limite é 100% de HP, uso limitado.");
			System.out.println("Avast = Gera um ataque que tira entre 0 - 75, porém uso limitado.");

			System.out.println("Digite 1 para voltar: ");
			op = input.nextInt();

		} while (op != 1);
	}

	static void Batalha(int capitulo) throws InterruptedException {
		int atkHacker = 0, atkAnd = 0, hpAnd = 0, op = 0;
		boolean saida = false, fim = true;

		Random valor = new Random();

		if (capitulo == 1)

			hpAnd = 100;

		else if (capitulo == 2)

			hpAnd = 120;

		else if (capitulo == 3)

			hpAnd = 140;

		System.err.println("\nPORTA COM INIMIGO PREPARE-SE PARA BATALHA!!!");

		switch (capitulo) {

		case 1:
			System.out.println("\n\nVÍRUS é o seu inimigo!");
			break;

		case 2:
			System.out.println("\n\nMAWARE é o seu inimigo!");
			break;

		case 3:
			System.out.println("\n\nO pior de todos o ZÉ GOTINHA ROBÓTICO é seu inimigo!");
			break;
		}

		do {

			do {
				saida = false;
				System.out.print("\n=======[Escolha uma das opções:]=======\n");
				System.out.print("====================================\n");
				System.out.print("||1 - Varredura                   ||\n");
				System.out.print("||2 - Windows Defender - " + defender+"        ||\n");
				System.out.print("||3 - Restaurar o Computador - " + restau + "  ||\n");
				System.out.print("||4 - Antivirus Avast - " + avast+"         ||\n");
				System.out.print("====================================\n");
				System.out.println("Digite uma das opções: ");
				op = input.nextInt();

				if (op > 5 || op < 1) {
					saida = true;
				}

			} while (saida);

			switch (op) {
			case 1:
				atkHacker = valor.nextInt(25);
				break;
			case 2:
				if (defender != 0) {
					atkHacker = valor.nextInt(50);
					defender--;
				} else {
					System.err.println("Você já não pode usar mais essa habilidade!\n");
					atkHacker = 0;
				}
				break;
			case 3:
				if (restau != 0) {

					if (hpHacker == 100) {
						System.err.println("Seu HP já está completo!!!");
					} else if (hpHacker > 80) {
						hpHacker = hpHacker + 20;
						int resto = hpHacker % 100;
						hpHacker = hpHacker - resto;
					} else {
						hpHacker = hpHacker + 20;
					}
				}
				atkHacker = 0;
				break;
			case 4:
				if (avast != 0) {
					atkHacker = valor.nextInt(75);
					avast--;
				} else {
					System.err.println("Você já não pode usar mais essa habilidade!\n");
					atkHacker = 0;
				}
				break;
			}
			hpAnd = hpAnd - atkHacker;

			switch (capitulo) {
			case 1:
				if (hpAnd != 0)
					atkAnd = valor.nextInt(10);
				hpHacker = hpHacker - atkAnd;
				break;
			case 2:
				if (hpAnd != 0)
					atkAnd = valor.nextInt(20);
				hpHacker = hpHacker - atkAnd;
				break;
			case 3:
				if (hpAnd != 0)
					atkAnd = valor.nextInt(30);
				hpHacker = hpHacker - atkAnd;
				break;
			}

			System.out.println("\nHP " + nome + ": " + hpHacker);
			System.out.println("HP do Inimigo: " + hpAnd + "\n");

			if (hpHacker <= 0 || hpAnd <= 0)
				fim = false;

		} while (fim);

	}

	static void questoes() throws InterruptedException {
		boolean saida = true, acertou = true;
		String alternativa = null, correta = null;
		ArrayList letras = new ArrayList<String>();
		ArrayList perguntas = new ArrayList<String>();

		letras.add("A");
		letras.add("B");
		letras.add("C");
		letras.add("D");

		// Teste 1
		System.out.println("O que são bibliotecas dentro de uma linguagem de programação?");
		System.out.println("A – Um local com muitos livros.");
		System.out.println("B – Um conjunto de livros que podem ser lidos dentro da IDE.");
		System.out.println(
				"C – Um conjunto de funções pré-escritas por outros programadores que já resolvem determinados problemas.");
		System.out.println("D – Local reservado para ler.");

		alternativa = input.next();

		if (alternativa.equals("C") || alternativa.equals("c")) {
			System.out.println("Alternativa correta!");
		} else {
			System.out.println("Alternativa incorreta!");
			acertos--;
		}

		// Teste 2
		System.out.println("O que é um vetor?");
		System.out.println("A – Um processo do Java.");
		System.out.println("B – O vetor é um laço de repetição.");
		System.out.println("C – O vetor é um sistema de condicional.");
		System.out.println("D – O vetor é um conjunto de variáveis.");

		alternativa = input.next();

		if (alternativa.equals("D") || alternativa.equals("d")) {
			System.out.println("Alternativa correta!");
		} else if (alternativa.equals("C") || alternativa.equals("c") || alternativa.equals("B")
				|| alternativa.equals("b") || alternativa.equals("A") || alternativa.equals("a")) {
			System.out.println("Alternativa incorreta!");
			acertos--;
		}

		// Teste 3
		System.out.println("O que é uma constante?");
		System.out.println("A – Uma variável com um valor fixo.");
		System.out.println("B – Uma variável que deve ser constantemente utilizada.");
		System.out.println("C – Uma biblioteca do Java.");
		System.out.println("D – Um processo de TI.");

		alternativa = input.next();

		if (alternativa.equals("A") || alternativa.equals("a")) {
			System.out.println("Alternativa correta!");
		} else if (alternativa.equals("C") || alternativa.equals("c") || alternativa.equals("B")
				|| alternativa.equals("b") || alternativa.equals("D") || alternativa.equals("d")) {
			System.out.println("Alternativa incorreta!");
			acertos--;
		}
		// Teste 4
		System.out.println("Em qual momento o laço de repetição Do While faz a verificação da condição?");
		System.out.println("A – Após rodar os comandos dentro do laço uma vez.");
		System.out.println("B – No início, antes de acontecer qualquer comando dentro do laço.");
		System.out.println("C – No meio dos comandos do laço.");
		System.out.println("D – Após aparecer o break, sem isso ele roda sem parar.");

		alternativa = input.next();

		if (alternativa.equals("A") || alternativa.equals("a")) {
			System.out.println("Alternativa correta!");
		} else if (alternativa.equals("C") || alternativa.equals("c") || alternativa.equals("B")
				|| alternativa.equals("b") || alternativa.equals("D") || alternativa.equals("d")) {
			System.out.println("Alternativa incorreta!");
			acertos--;
		}

		// Teste 5
		int opcao;
		do {
			System.out.println(
					"Uma variável char recebe mais de um caractere, podendo receber todos os dados de um sistema,\n"
							+ "como nome, sobrenome, números de CPF entre outros, isso tudo com apenas uma variável.");
			System.out.println("A afirmação acima é:");
			System.out.println("Digite 1 – Verdadeira\nDigite 2 – Falsa");
			opcao = input.nextInt();
			if (opcao == 2) {
				System.out.println("Êxito: sua escolha trouxe consequências!");
				acertos--;
				saida = false;
			} else if (opcao == 1) {
				System.out.println("Falha: você é tão burro que chega a ser esperto!");
				saida = false;
			} else {
				System.out.println("Resposta inválida.");
				saida = true;

			}

		} while (saida);

		// Teste 6
		perguntas.add(" – short – byte – int – long");
		perguntas.add(" – int – short – byte – long");
		perguntas.add(" – long – int – short – byte");
		perguntas.add(" – byte – short – int – long");

		correta = " – byte – short – int – long";

		do {

			saida = false;
			Collections.shuffle(perguntas);
			Collections.shuffle(perguntas);

			System.out.println("Qual é a ordem de tamanho na declaração das variáveis?");

			for (int i = 0; i < perguntas.size(); i++) {

				System.out.println(letras.get(i) + "" + perguntas.get(i));

			}

			alternativa = input.next();

			switch (alternativa) {

			case "A":
			case "a":

				if (perguntas.get(0).equals(correta)) {

					System.out.println("Êxito: Você ativou Ultron Full Pistola!");

				} else {

					System.out.println("Falha: Hominídeo que faz figuras rupestres!");

					acertos--;
				}

				break;

			case "B":
			case "b":

				if (perguntas.get(1).equals(correta)) {

					System.out.println("Êxito: Você ativou Ultron Full Pistola!");

				} else {

					System.out.println("Falha: Hominídeo que faz figuras rupestres!");

					acertos--;
				}

				break;

			case "C":
			case "c":

				if (perguntas.get(2).equals(correta)) {

					System.out.println("Êxito: Você ativou Ultron Full Pistola!");

				} else {

					System.out.println("Falha: Hominídeo que faz figuras rupestres!");

					acertos--;
				}

				break;

			case "D":
			case "d":

				if (perguntas.get(3).equals(correta)) {

					System.out.println("Êxito: Você ativou Ultron Full Pistola!");

				} else {

					System.out.println("Falha: Hominídeo que faz figuras rupestres!");

					acertos--;
				}

				break;

			default:

				saida = true;

			}

		} while (saida);

		// Teste 7

	}

	static void Selecao() throws InterruptedException {
		boolean saida = false;

		do {
			System.out.println("\n..::SELEÇÃO DE CAPÍTULOS::..\n");
			System.out.println("1 - Capítulo 1");
			System.out.println("2 - Capítulo 2");
			System.out.println("3 - Capítulo 3");
			System.out.println("4 - Capítulo 4");
			System.out.println("5 - Voltar");

			int escolha = input.nextInt();

			switch (escolha) {
			case 1:
				Capitulo1();
				saida = true;
				break;
			case 2:
				Capitulo2();
				saida = true;
				break;
			case 3:
				Capitulo3();
				saida = true;
				break;
			case 4:
				Capitulo4();
				saida = true;
				break;
			case 5:
				Menu();
				saida = true;
				break;
			default:
				System.out.println("Opção Inválida!");
				break;

			}
		} while (!saida);
	}

	static void Creditos() throws InterruptedException {
		int volta;

		do {
			System.out.println("*--*Créditos*--*");

			System.out.println("Criado por:\n-> Erick\n-> Larissa\n-> Leonis\n-> Rodrigo\n-> Professor:4 Takeo");

			System.out.println("\nDigite 1 para voltar.");

			volta = input.nextInt();

		} while (volta != 1);

		Menu();
	}

	static void Introducao() throws InterruptedException {
		int volta;

		do {
			System.out.print("\n==========================[Introdução]================================\n");
			System.out.print("======================================================================\n");
			Apresenta("\nNo ano de 2050, o mundo segue com uma realidade totalmente centrada", TimeUnit.MILLISECONDS,
					temp_dialog);
			Apresenta("+\nem tecnologia e com IA cada vez mais presente na vida das pessoas. ", TimeUnit.MILLISECONDS,
					temp_dialog);
			Apresenta("+\n\nNos arredores de uma cidade chamada Seven, vive Starkeo; um homem que",
					TimeUnit.MILLISECONDS, temp_dialog);
			Apresenta("+\njá viveu muitas gerações, graças à tecnologia criada pelo próprio. (Mas isso",
					TimeUnit.MILLISECONDS, temp_dialog);
			Apresenta("+\nnós veremos em outro trabalho, de outro projeto). Uma de suas criações foi",
					TimeUnit.MILLISECONDS, temp_dialog);
			Apresenta("+\nUltron, uma máquina criada com o intuito de proteger a Terra. Tudo estava",
					TimeUnit.MILLISECONDS, temp_dialog);
			Apresenta("+\nindo muito bem, até que com o passar do tempo, Ultron foi criando", TimeUnit.MILLISECONDS,
					temp_dialog);
			Apresenta("+\npersonalidade própria e já não concordava com o seu propósito e começou",
					TimeUnit.MILLISECONDS, temp_dialog);
			Apresenta("+\na ter ideias distorcidas da realidade. Mas o que ninguém sabia, ou melhor,",
					TimeUnit.MILLISECONDS, temp_dialog);
			Apresenta("+\nalguém descobriu, é que na verdade Ultron foi infectado com um vírus que",
					TimeUnit.MILLISECONDS, temp_dialog);
			Apresenta("+\nestá afetando todo o seu sistema.", TimeUnit.MILLISECONDS, temp_dialog);
			Apresenta("+\n\nDesde então, o mundo corre sério risco de extinção! ", TimeUnit.MILLISECONDS, temp_dialog);
			Apresenta("+\n\nSerá você a pessoa que poderá recuperar Ultron? ", TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n\nDigite 1 para voltar e aceitar essa missão se for capaz!!");

			volta = input.nextInt();

		} while (volta != 1);

		Menu();

	}

	static void Capitulo1() throws InterruptedException {
		String alternativa = null;
		boolean saida = false;
		int op = 0;
		capitulo = 1;

		System.out.print("\n===============================[PARTE I]========================================\n");
		System.out.print("================================================================================\n");
		/*
		 * Verificar a a parte visual do texto, formas de colocar algum tipo de enfeite,
		 * alem do numero de frases que há em cada parte, aqui optei por uma por vez
		 */
		Apresenta("\nO ano é 2050, vivemos numa época de grande dificuldade causado pelo", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nexcesso de pessoas no mundo, catástrofes cada vez mais violentas e o", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nprincipal: a escassez de alimento. São 16,7 bilhões de pessoas e 2/3 vivem", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nem situação alarmante.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nEis que um cientista que vem pesquisando há anos um modo de alimentar", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ntoda a humanidade, e prevenir que esses desastres devastem ainda mais o", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nplaneta; cria Ultron. Que é a inteligência artificial criado por Starkeo para",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\najudar nessa empreitada. No começo foram mil maravilhas com Ultron", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nguiando a humanidade para um caminho próspero, porém, Ultron não", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nestava completo. Essa inteligência artificial tinha “correntes” que o limitava",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\npor precaução. Starkeo; o gênio, playboy, filantropo e gênio (não tão gênio",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nassim) decide tirar o limitador de Ultron acreditando que ele poderia fazer",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nainda mais coisas pela humanidade, realmente ele pode e o que ele decide", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nfazer?", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\n", TimeUnit.MILLISECONDS, temp_dialog);
		System.out.println("\n");
		Apresenta("\nUm dos maiores desenvolvedores " + nome + " de uma das maiores", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nempresas de tecnologia, logo percebeu o que acontecera, através de um", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nalgoritmo de previsão " + nome + " calculou o que estava acontecendo e", TimeUnit.MILLISECONDS,
				temp_dialog);

		Apresenta("\nbaseado nesses cálculos previu o que estava por vir.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\n-”+nome+”- eu tenho que entrar em contato com Starkeo, mas como?! ", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nAntes mesmo de " + nome + " terminar o que estava fazendo, batem em sua porta.",
				TimeUnit.MILLISECONDS, temp_dialog);
		System.err.println("TOC, TOC, TOC");/*
											 * Verificar a apresentação dos diálogos, no inicio é muito texto, já que
											 * até então é padrão, porem nos diálogos talvez dê para colocar algo mais
											 * interativo
											 */
		Apresenta("\nVocê é o " + nome + " ?", TimeUnit.MILLISECONDS, temp_dialog);// Sugestão é criar uma interação com
																					// o usuário e gerar consequêcias
		Apresenta("\n- Perguntou um homem parrudo de 2,10m.", TimeUnit.MILLISECONDS, temp_dialog);

		do {

			System.out.println("\nEscolha uma das opções abaixo: ");
			System.out.println("1 - Responder o homem.");
			System.out.println("2 - Pular a janela.");
			System.out.print("Digite a opção: ");
			op = input.nextInt();

			if (op == 2) {

				hpHacker = hpHacker - 10;

				Apresenta("\nVocê cai bruscamente perdendo 10 pontos de HP.", TimeUnit.MILLISECONDS, temp_dialog);
				Apresenta("\nAlém disso, sua escolha foi em vão. Mesmo pulando a janela", TimeUnit.MILLISECONDS,
						temp_dialog);
				Apresenta("\nacaba encontrando o homem te aguardando da mesma forma.", TimeUnit.MILLISECONDS,
						temp_dialog);

			}

		} while (op < 1 || op > 2);

		Apresenta("\n-Depende. Te devo alguma grana? Questionou " + nome, TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\n-Você é ou não é " + nome + " ? Replicou o homem estranho.", TimeUnit.MILLISECONDS, temp_dialog);
		System.err.println("- Sim, eu sou!");
		Apresenta("\n Respondeu " + nome, TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nSaindo do apartamento " + nome + " sente uma pancada na cabeça e logo", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ndesmaia.", TimeUnit.MILLISECONDS, temp_dialog);
		System.err.println("Ele acorda em uma banheira de gelo sem seu rim. Mentira!");
		Apresenta("\nNa verdade, ele acorda nas instalações Starkeo, mas em uma sala", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nreservada com uma tremenda enxaqueca. Starkeo adentra na sala e", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\npergunta com desdém: você é o " + nome + " que anda bisbilhotando minha", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nrede?", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nEu estava cuidando da sua rede, diferente de você! Você percebeu o que", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nfez? Retrucou " + nome, TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\n-   Você fala de Ultron?! Foi um pequeno erro técnico, não imaginei que ele",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\npudesse fazer aquilo, mas já temos tudo sob controle! Disse Starkeo com", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nfirmeza.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\n- Um erro técnico é algo pequeno perto do que ele está fazendo e pode", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nfazer! Você simplesmente encheu de “esteroides” essa IA que você se ", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nrefere como Ultron, nunca viu aqueles filmes de uns 30 anos atrás da", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nMarvel, não?!", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nStarkeo leva o " + nome + " para a sala de controle para mostrar que", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nestava tudo sob controle, mas chegando lá, Ultron se tornou mais forte e", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ncontrolando mais da rede e de outras máquinas.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nStarkeo sem saber o que fazer fica parado, enquanto " + nome + " corre", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\npara o computador e tenta inibir a máquina.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\n- Vou tentar separar ele da rede para ele não fugir! Diz o " + nome, TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\n Ao sentar na cadeira e se preparar para conversar com Ultron, uma voz de ", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ngás hélio surge na sala e pergunta. – Quem sois vós?  ", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nSem entender nada, " + nome + " pergunta: quem está falando? De quem é", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nessa voz de taquara rachada? - Enquanto cai na gargalhada.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nUltron responde: – Durante longínquos tempos vossa espécie foi a", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ndominante perante outras raças, doravante não mais ditará as regras, eu", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ndetenho todas as vossas riquezas que por ventura são guardados em", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nbancos e obtenho controle sobre vosso armamento, em franqueza, tenho", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ncontrole sobre qualquer equipamento cuja o dito obtenha funcionalidade", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\natravés de corrente alternada ou corrente contínua.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\n" + nome + " rindo da voz e sem entender nada pergunta o que ele quis", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ndizer. - A voz dele é muito engraçada, mas ele fala de uma forma muito", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nculta e isso é demais para mim. O que esse Ultron quis dizer?", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nStarkeo traduz o que o Ultron disse: Ele disse que não somos mais a espécie",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\ndominante e que tem controla dos bancos e armamento e tudo que é", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\neletrônico, basicamente isso!", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nStarkeo então reuniu uma equipe de desenvolvedores: um hacker, um", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\njogador de GTA San Andreas e um jogador de Tíbia, um desenvolvedor que só.", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nfaz ADO e VOCÊ para combater Ultron.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nCada um sentado em sua posição e pronto para enfrentar Ultron, o jogador", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nde Tíbia encontra a primeira defesa de Ultron mas não consegue passar,", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nentão " + nome + " vai até a mesa dele e olha a primeira barreira de defesa",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nde Ultron.", TimeUnit.MILLISECONDS, temp_dialog);// O inicio contem muito texto, vamos tentar criar
																		// uma interação com usuário no meio do caminho

		Apresenta("\nAntes de podermos quebrar a barreira do Ultron, devemos desvendar o caminho", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\naté a barreira.", TimeUnit.MILLISECONDS, temp_dialog);//
		System.out.println();
		Apresenta("\nGraças à uma tecnologia criada por Starkeo, podemos acessar esse caminho", TimeUnit.MILLISECONDS,
				temp_dialog);//
		Apresenta("\ne passar pelas camadas de segurança.", TimeUnit.MILLISECONDS, temp_dialog);//
		Apresenta("\nporém, devemos escolher a porta correta, se ela estiver livre podemos acessar",
				TimeUnit.MILLISECONDS, temp_dialog);//
		Apresenta("\na barreira sem dificuldades.", TimeUnit.MILLISECONDS, temp_dialog);//
		Apresenta("\nMas se tiver algum guarda do Ultron, devemos entrar numa batalha cibernética.", TimeUnit.MILLISECONDS,
				temp_dialog);//
		Apresenta("\nMas não se preocupe, o sistema computacional do Starkeo tem algumas", TimeUnit.MILLISECONDS,
				temp_dialog);//
		Apresenta("\nferramentas úteis contra seus inimigos, porém algumas são limitadas.", TimeUnit.MILLISECONDS,
				temp_dialog);//

		System.err.println("\nTutorial de Batalha: ");

		IntrucoesBat();

		PortaAcesso();

		System.err.println("\nVocê passou o caminho, vamos seguir adiante.");

		System.err.println("\n\n-Ultron: Vamos testar seu conhecimento: ");

		do {
			saida = false;
			System.out.println("O que são bibliotecas dentro de uma linguagem de programação?");
			System.out.println("A – Um local com muitos livros.");
			System.out.println("B – Um conjunto de livros que podem ser lidos dentro da IDE.");
			System.out.println(
					"C – Um conjunto de funções pré-escritas por outros programadores que já resolvem determinados problemas.");
			System.out.println("D – Local reservado para ler.");
			alternativa = input.next();

			if (alternativa.equals("C") || alternativa.equals("c")) {
				Apresenta("Êxito -- Você passou a defesa de Ultron.", TimeUnit.MILLISECONDS, temp_dialog);
			} else if (alternativa.equals("A") || alternativa.equals("a") || alternativa.equals("B")
					|| alternativa.equals("b") || alternativa.equals("D") || alternativa.equals("d")) {
				Apresenta("Falha -- Parece não haver forma de vida inteligente nas proximidades.",
						TimeUnit.MILLISECONDS, temp_dialog);
				acertos--;
			} else {
				System.err.println("NÃO SEJA RETARDADO! POR FAVOR DIGITE UMA DAS OPÇÕES!!!\n");
				saida = true;
			}
		} while (saida);

		Apresenta("\nSeguindo o plano de deter Ultron a equipe segue focada, menos o jogador", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nde GTA que estava numa guerra com os BALA’s.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nStarkeo liga a tv para ver os noticiários. – Ultron invade o sistema de defesa",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\ndo exército e instala o terror no Pentágono.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nDepois de um trabalho estressante de 32 minutos, a equipe pede uma pausa", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\npara o lanche enquanto o mundo pega fogo lá fora.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nO " + nome + " vai à lanchonete do Starkeo e pede o cardápio. ", TimeUnit.MILLISECONDS,
				temp_dialog);

		// Realizar uma interação com o usuário e o cardápio, ver as possibilidades de
		// interação como comer o lanche e
		// se possível ganhar algum beneficio

		/*
		 * Escolha suas opções: Bebida muito famosa no México: Cueca - Cuela. Café.
		 * Suco. Jack Daniel. Chevette Para comer: Pão na chapa BigMac Salada de frutas
		 * Feijão com repolho Churrasco.
		 */

		Apresenta("\nFeita a pausa rápida de 4 horas e prontos para trabalhar cheios de energia,",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nmais uma vez o jogador de Tíbia conjura um Utevo Lux e acha outra barreira", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nna defesa de Ultron.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nStarkeo pergunta aos outros o que estão fazendo que só o jogador de Tíbia", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nestá encontrando as barreiras. Olhando para o computador de cada um, ele", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nvê o desenvolvedor fazendo sua última ADO para um professor russo", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nchamado TAKELOVISK para não ficar em DP.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nQuestionado por Starkeo o que eles estavam fazendo em um momento", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ndesse, ele responde que o mundo é importante, mas a matéria é mais!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nObservando os outros da equipe ele vê o hacker stalkeando uma ex.", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nSem entender nada, ele se pergunta onde arrumou aquela equipe e um dos", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nfuncionários disse que esses simplesmente são os melhores, são apenas ", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\navoados.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nE quando ele vai até o " + nome + ", ele o vê comprando ações das", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nIndústrias Starkeo, já que não estavam valendo muito. Então Starkeo pede ", TimeUnit.MILLISECONDS,
				temp_dialog);
		System.err.println("\natenção para a próxima fase e se inicia o teste.");

		PortaAcesso();

		System.out.println("\nVocê passou o caminho.\n");

		System.err.println("Vamos para o teste da quebra de barreira!");

		do {
			saida = false;
			System.out.println("O que é um vetor?");
			System.out.println("A – Um processo do Java.");
			System.out.println("B – O vetor é um laço de repetição.");
			System.out.println("C – O vetor é um sistema de condicional.");
			System.out.println("D – O vetor é um conjunto de variáveis.");

			alternativa = input.next();

			if (alternativa.equals("D") || alternativa.equals("d")) {
				System.out.println(
						"Ultron: Criatura humanóide, se você prosseguir vou espalhar seu histórico da internet!!!");
			} else if (alternativa.equals("C") || alternativa.equals("c") || alternativa.equals("B")
					|| alternativa.equals("b") || alternativa.equals("A") || alternativa.equals("a")) {
				System.out.println("Sua ancestral Eva também falhou, não fique triste!");
				acertos--;
			} else {
				System.err.println("NÃO SEJA RETARDADO! POR FAVOR DIGITE UMA DAS OPÇÕES!!!\n");
				saida = true;
			}
		} while (saida);

		Apresenta("\nAo trocar os canais da tv só se vê desastres: aviões que caíram, trens que", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nbateram, todos os tipos de transportes parados, sessão da tarde passando ", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nA Lagoa Azul...", TimeUnit.MILLISECONDS, temp_dialog);

		System.out.print("\n================================================================================\n");
		System.out.print("================================================================================\n");

		Capitulo2();

	}

	static void Capitulo2() throws InterruptedException {
		String alternativa = null;
		boolean saida = false;
		capitulo = 2;
		System.out.print("\n===============================[PARTE II]=======================================\n");
		System.out.print("================================================================================\n");

		Apresenta("\nUma outra equipe também estava tentando combater Ultron mas não", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nconseguiam nem passar do login.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nPara impedir que a equipe de Starkeo continuasse combatendo Ultron,", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nUltron decide cortar a energia das instalações, mas Starkeo já imaginava", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nque algo assim poderia acontecer então ele construiu um edifício autossustentável", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nafim de evitar pagar as contas de luz que são um absurdo e ataques externos.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nJá haviam se passado horas e a equipe não avançou mais, já se passa de", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nmeia noite e eles resolveram revezar para um breve descanso, quando do", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nnada o jogador de GTA grita na sala: ACHEI!!!", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nQuem estava dormindo acorda com o susto e corre até ele e pergunta o que", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nele achou.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nE ele responde: achei o pé grande no GTA, sabia que não era só mito da", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ninternet, cara que emoção!!", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nTodos que acordaram com o susto, voltaram para seus quartos até dar a", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nsua hora de voltar ao trabalho.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nQuando de repente um barulho ensurdecedor mais uma vez acordou todos.", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nDessa vez era Ultron dizendo: venho por meio desta, comunicar que irei proferir um ataque ás ", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\n09:03 do horário de Brasília à duas torres de um país sul-americano cuja língua oficial é o português, ", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ncom uma bomba. ", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nCiente da ameaça, Starkeo pressiona a equipe: - Dormimos demais! Quem era para nos acordar? Temos ", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nde descobrir logo como parar isso, não podemos deixar que ele consiga!", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nO jogador de GTA ainda sonolento, se pergunta o que ele havia perdido...", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\n" + nome + " se for as torres que eu acho que são, Ultron fará um favor", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\naquele país, deixa pra lá, recomeçamos a atacar Ultron às 9:04!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nStarkeo se levanta e diz que não podemos deixar inocentes morrer, pensem", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nnos funcionários!", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nRefletindo," + nome + "vai até um dos computadores e rapidamente acha", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\na fase 3 e logo faz uma exigência: - Eu achei a próxima defesa de Ultron,", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nmas eu preciso de um copo de café com leite e um pão com manteiga na", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nchapa ou uma Cueca-Cuela e um pedaço de lasanha senão não vou", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nconseguir me concentrar!!", TimeUnit.MILLISECONDS, temp_dialog);

		/*
		 * Escolha: Café com leite e pão na chapa. Cueca-Cuela e lasanha.
		 */

		Apresenta("\nPronto agora eu posso prosseguir!", TimeUnit.MILLISECONDS, temp_dialog);

		PortaAcesso();

		do {
			saida = false;
			System.out.println("O que é uma constante?");
			System.out.println("A – Uma variável com um valor fixo.");
			System.out.println("B – Uma variável que deve ser constantemente utilizada.");
			System.out.println("C – Uma biblioteca do Java.");
			System.out.println("D – Um processo de TI.");

			alternativa = input.next();

			if (alternativa.equals("A") || alternativa.equals("a")) {
				System.out.println("Você vai deixar aquele tipo de pessoas vivas?");
			} else if (alternativa.equals("C") || alternativa.equals("c") || alternativa.equals("B")
					|| alternativa.equals("b") || alternativa.equals("D") || alternativa.equals("d")) {
				System.out.println("Você falhando está fazendo mais bem do que mal!");
				acertos--;
			} else {
				System.err.println("NÃO SEJA RETARDADO! POR FAVOR DIGITE UMA DAS OPÇÕES!!!\n");
				saida = true;
			}
		} while (saida);

		Apresenta("\nTerminado o teste, a equipe segue tentando desvendar mais defesas e", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nenfraquecer Ultron.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nA cada teste que avançamos, mais perigoso Ultron fica.", TimeUnit.MILLISECONDS, temp_dialog);
		System.out.println("\n_____________________________________________________________________________");
		System.out.println("\n_____________________________________________________________________________");
		Apresenta("\nAo perceber um terremoto leve na região onde estão, logo Starkeo procura", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\no epicentro. O lugar é na costa de Portugal, no mesmo lugar onde se deu", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\num terremoto devastador no século 18. Além do terremoto, um tsunami se", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nformou para devastar a costa do continente. Com os governos trabalhando", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nem conjunto para diminuir as perdas, (menos o governo chinês, que só", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\npensam em seus próprios interesses). Ao pesquisar mais a fundo, Starkeo", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ndescobre que o terremoto foi causado por Ultron, para desviar a atenção do", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ngrupo de desenvolvedores.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nMuito bem pessoal, Ultron está tentando nos desfocar, ele sabe que", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nestamos nos aproximando do núcleo dele e vai tentar nos distrair a todo", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ncusto... Ei, o que você está fazendo? Questiona Starkeo espumando pela", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nboca!", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nEstou vendendo Tibiacoin! Disse o jogador de Tíbia.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nEstamos a beira da extinção e você está vendendo moeda de joguinho?!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nSe não está bom para você, pode pegar suas coisas e sair!!! ", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nExclamou Starkeo.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nEm seguida," + nome + "diz: se ele sair da equipe eu também saio!", TimeUnit.MILLISECONDS, temp_dialog);
		//Opção 1:  os dois ficam na equipe (caso permaneçam continuar a história)
               //Opçao2: os dois saírem da equipe (caso saiam novo diálogo. – Estamos indo embora!!
               //Mentira, só vamos pegar uns salgadinhos e já voltamos!
		//Assim que eles voltam logo encontram a próxima fase!

		Apresenta("\n- Pessoal, achei a próxima barreira de defesa do Ultron. Disse " + nome + ".",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nAo começar a decodificar, Ultron começa a jogar spam na tela para impedir", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nde continuar.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nJogador de Tíbia: nossa, esse tanto de spam parece uns site suspeitos que", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\neu andava fazendo minhas pesquisas!", TimeUnit.MILLISECONDS, temp_dialog);

		PortaAcesso();

		do {
			saida = false;
			System.out.println("Em qual momento o laço de repetição Do While faz a verificação da condição?");
			System.out.println("A – Após rodar os comandos dentro do laço uma vez.");
			System.out.println("B – No início, antes de acontecer qualquer comando dentro do laço.");
			System.out.println("C – No meio dos comandos do laço.");
			System.out.println("D – Após aparecer o break, sem isso ele roda sem parar.");

			alternativa = input.next();

			if (alternativa.equals("A") || alternativa.equals("a")) {
				System.out.println(" Mal-feito, feito!");
			} else if (alternativa.equals("C") || alternativa.equals("c") || alternativa.equals("B")
					|| alternativa.equals("b") || alternativa.equals("D") || alternativa.equals("d")) {
				System.out.println("Avadakedrava!");
				acertos--;
			} else {
				System.err.println("NÃO SEJA RETARDADO! POR FAVOR DIGITE UMA DAS OPÇÕES!!!\n");
				saida = true;
			}
		} while (saida);

		Apresenta("\nA equipe estava avançando já com 40% dos problemas resolvidos e se", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nsentindo confiantes, quando o inesperado acontece: um time alviverde cuja", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nreferência é uma árvore cujo fruto é palmito, ganha o mundial pela primeira",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nvez!", TimeUnit.MILLISECONDS, temp_dialog);

		System.out.print("\n================================================================================\n");
		System.out.print("================================================================================\n");

		Capitulo3();
	}

	static void Capitulo3() throws InterruptedException {
		String alternativa = null, correta = null;
		int opcao;
		boolean saida = false;
		ArrayList letras = new ArrayList<String>();
		ArrayList perguntas = new ArrayList<String>();

		letras.add("A");
		letras.add("B");
		letras.add("C");
		letras.add("D");

		capitulo = 3;
		System.out.print("\n===============================[PARTE III]======================================\n");
		System.out.print("================================================================================\n");

		Apresenta("\nMudando de assunto, Ultron sente que pode perder e começa a jogar uma ", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nnação contra outra, com ameaças, Ultron acessa o CCD, mas não consegue", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nacessar as áreas mais seguras onde se encontra um vírus letal. Então Ultron maquia o sistema", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\npara a equipe acessar e acabar liberando o vírus, achando que está", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nimpedindo, a equipe de Starkeo vê algo estranho e inicia o próximo teste...", TimeUnit.MILLISECONDS,
				temp_dialog);
		


		PortaAcesso();

		Apresenta("\nUma ventania se inicia do lado de fora do prédio e começam a sair faíscas", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nde todos os lugares, quando sai um homem de uma fenda e começa a", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nchamar pelo " + nome + ".", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\n- Esse teste é uma armadilha!!! Grita o homem do lado de fora do prédio.", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nSem dar muita atenção a equipe continua ...", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nEntão um outro portal se abre, mas agora dentro das instalações. Sai um homem desse portal, ", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ngritando muito para a equipe ouvisse o que o outro homem estava gritando lá fora! ", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nHomem misterioso dentro da instalação: – Vocês não estão me ouvindo gritar lá fora não?! ", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nAquele lá fora sou eu, mas você não me deram ouvidos e num mundo diferente vocês liberaram um vírus quando realizaram esse teste!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\n A equipe fica olhando um para a cara do outro e entram em consenso para fazer o teste:", TimeUnit.MILLISECONDS,
				temp_dialog);
		

		do {
			System.out.println(
					"Uma variável char recebe mais de um caractere, podendo receber todos os dados de um sistema,\n"
							+ "como nome, sobrenome, números de CPF entre outros, isso tudo com apenas uma variável.");

			System.out.println("A afirmação acima é:");
			System.out.println("Digite 1 – Verdadeira\nDigite 2 – Falsa");

			opcao = input.nextInt();

			if (opcao == 2) {

				System.out.println("Êxito: sua escolha trouxe consequências!");

				acertos--;

				saida = false;

			} else if (opcao == 1) {

				System.out.println("Falha: você é tão burro que chega a ser esperto!");
				saida = false;

			} else {

				System.out.println("Resposta inválida.");
				saida = true;
			}

		} while (saida);

		Apresenta("\nAssim que finalizam o teste, Starkeo começa a fazer perguntas ao homem misterioso.", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\n- Quem é você? De onde você veio, como você veio para aqui? (Hoje à noite no Globo repórter).", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nMeu nome é Orácio P. McTetas, eu vim de uma época em que Ultron", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ndevastou o mundo com um vírus, que reduziu a população em 99%. Eu", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ntentei voltar uma época antes do “gênio, playboy, filantropo não tão gênio”",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\ncriasse Ultron, mas a bateria só me trouxe até essa época. Esse teste era o",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\ngatilho que liberava o vírus. Ao responder corretamente o vírus é liberado e",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nao errar você cortaria o acesso de Ultron ao CCD.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nEntão o hacker pergunta: De que ano você veio?", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nOrácio responde: eu vim de 2077!", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nCyberpunk ainda tem bug? Pergunta o jogador de Tíbia.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nEntão Orácio responde: em 2077 não temos pessoas o suficiente, então", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nbasicamente vivemos em comunidade e comemos o que plantamos, não", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ntemos energia elétrica nem nada parecido. Um dos sobreviventes", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nmencionou uma viagem no tempo e de um protótipo na área 51.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nEncontramos o protótipo em 2065, mas demoramos 12 anos para finalizar e", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nficamos 12 anos juntando energia para usarmos na máquina.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nEntão o desenvolvedor pergunta sobre o que ele sabe de Ultron e como", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nchegar até o núcleo dele.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nOrácio diz que na época dele, Ultron havia deixado a terra em 2059. Ela", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nestava praticamente morta por causa do último recurso da humanidade, a", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\noperação “Dark Sky”. Nela, os humanos bloqueiam o sol para impedir as", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nmáquinas de se recarregarem.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nSem fonte de energia aqui, Ultron juntou todas as reservas de energia e", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nconstruiu uma nave para colonizar outros mundos para se manter “vivo”.", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nEnquanto Orácio contava essa história, Ultron através de uma máquina de", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nterra-formação, ativa um vulcão do Círculo de fogo, que se não fosse", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nimpedido a tempo, todos os vulcões entrariam em erupção.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nPara tentar barrar Ultron a equipe precisa passar mais um teste:", TimeUnit.MILLISECONDS,
				temp_dialog);

		PortaAcesso();

		perguntas.add(" – short – byte – int – long");
		perguntas.add(" – int – short – byte – long");
		perguntas.add(" – long – int – short – byte");
		perguntas.add(" – byte – short – int – long");

		correta = " – byte – short – int – long";

		do {

			saida = false;
			Collections.shuffle(perguntas);
			Collections.shuffle(perguntas);

			System.out.println("Qual é a ordem de tamanho na declaração das variáveis?");

			for (int i = 0; i < perguntas.size(); i++) {

				System.out.println(letras.get(i) + "" + perguntas.get(i));

			}

			alternativa = input.next();

			switch (alternativa) {

			case "A":
			case "a":

				if (perguntas.get(0).equals(correta)) {

					System.out.println("Êxito: Você ativou Ultron Full Pistola!");

				} else {

					System.out.println("Falha: Hominídeo que faz figuras rupestres!");

					acertos--;
				}

				break;

			case "B":
			case "b":

				if (perguntas.get(1).equals(correta)) {

					System.out.println("Êxito: Você ativou Ultron Full Pistola!");

				} else {

					System.out.println("Falha: Hominídeo que faz figuras rupestres!");

					acertos--;
				}

				break;

			case "C":
			case "c":

				if (perguntas.get(2).equals(correta)) {

					System.out.println("Êxito: Você ativou Ultron Full Pistola!");

				} else {

					System.out.println("Falha: Hominídeo que faz figuras rupestres!");

					acertos--;
				}

				break;

			case "D":
			case "d":

				if (perguntas.get(3).equals(correta)) {

					System.out.println("Êxito: Você ativou Ultron Full Pistola!");

				} else {

					System.out.println("Falha: Hominídeo que faz figuras rupestres!");

					acertos--;
				}

				break;

			default:
				saida = true;
			}
		} while (saida);

		Apresenta("\nEstamos avançando bem, o mundo está acabando, as nações entrando em", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nguerra, tem uma escassez de alimento..., mas estamos indo bem!", TimeUnit.MILLISECONDS,
				temp_dialog);

		System.out.print("\n================================================================================\n");
		System.out.print("================================================================================\n");

		Capitulo4();

	}

	static void Capitulo4() throws InterruptedException {
		String alternativa = null;
		boolean saida = false;
		ArrayList letras = new ArrayList<String>();
		ArrayList perguntas = new ArrayList<String>();
		int op = 0;

		letras.add("A");
		letras.add("B");
		letras.add("C");
		letras.add("D");

		System.out.print("\n===============================[PARTE VI]=======================================\n");
		System.out.print("================================================================================\n");

		Apresenta("\nA equipe se reúne em frente a tela do Jogador de GTA e perguntam o que", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nele está fazendo.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nEle responde: vou fazer o código do Jetpack do Rhino e tirar as estrelas!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\n" + nome + " quer ir ao terraço? E você hacker stalkeador, quer ir também?", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nPergunta o jogador de Tíbia.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nChegando lá, eles observam a cidade, que estava em completo caos: ruas ", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\npegando fogo, acidentes. Em seguida, logo o jogador de Tíbia diz: a cidade", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nestá um caos, mas não está pior que o Rio de Janeiro, vamos voltar logo", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\npara dentro e acabar com essa torradeira elétrica!", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nAo entra na sala, o hacker encontra a próxima defesa de Ultron.", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nUltron depois de um longo período sem se comunicar com eles, chama", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\natenção da equipe:", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\n- Seres biológicos que defecam na água, não estão cansados de todo esse", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nárduo trabalho que não vos levará há lugar nenhum? Apenas farão meu", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nplano atardar em decorrência do espaço-tempo que estamos no presente", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nmomento. Não importa o quão longe conseguiste ir, nunca chegarão de", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nencontro ao meu centro de consciência, que por voz conheceste por núcleo!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nExclusivamente esse Homo Hábilis que esvai todo o tempo que lhe resta", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nfazendo Atividade Docente Orientada!", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nDesenvolvedor - Ele me chamou de Homo Habilis, deve ser em latim para", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nhomem habilidoso, certeza! O que você acha" + nome +"?", TimeUnit.MILLISECONDS, temp_dialog);

		do {

			System.out.println("\n\n" + nome + ": ");
			System.out.println("Opção 1 -> Acho que ele referiu à você como um dos primeiros primatas "
					+ "\na utilizar ferramentas de pedra lascada, o que lhe valeu o nome: habilis o "
					+ "\nhabilidoso.");
			System.out.println(
					"Opção 2 -> Tenho certeza de que ele te chamou de habilidoso mesmo, " + "\nvocê é diferenciado!");
			System.out.print("Digite a opção: ");
			op = input.nextInt();

		} while (op != 1);

		if (op == 1)

			System.out.println("\nNem todas as escolhas da vida tem consequências");

		else if (op == 2)

			System.out.println("\nNem todas as escolhas da vida tem consequências");

		System.out.println("Mas ironia é sacanagem hein ");

		Apresenta("\nEnquanto eles discutem, Starkeo chega até a próxima barreira de Ultron e", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\npassa ao " + nome + " para completar o teste!", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nStarkeo achei a próxima fase, segura a bomba aí " + nome + "!", TimeUnit.MILLISECONDS,
				temp_dialog);
		
		//Teste 7:
	       //Êxito: Acertou mizerávi!!
		//Falha: Como tal ser chegou tão longe tendo só 2 neurônios?


		Apresenta("\nO jogador de GTA e o jogador de Tíbia fazem uma aposta de quem", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nganharia: se era Ultron ou a humanidade. O jogador de GTA diz que a", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nhumanidade ganha e o jogador de Tíbia diz que não importa quem ganha ou", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nquem perde, vai todo mundo perder. ", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nO Hacker finalmente consegue um êxito ao invadir o Facebook e recuperar", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nsua conta com quase 5000 amigos. – O pai tá on!", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\no " + nome + " pesquisando alguma forma derrotar Ultron, encontra um", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\narquivo confidencial de Starkeo perdido no galpão da empresa. Nesses", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\narquivos contém instruções para acessar o núcleo de Ultron e assim parar", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nessa cadeia de catástrofes e tragédias.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nAo acessar essas instruções, vemos 3 testes propostos e que são", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nextremamente arriscados. Para ter êxito ao chegar no núcleo, é necessário", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nacertar os 3 testes sem errar nenhum.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nCaso você erre algum dos testes, Ultron saberá e lançará todas as ", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ncatástrofes de uma só vez.", TimeUnit.MILLISECONDS, temp_dialog);
		
		// Teste 8
		//Teste 9
		//Teste 10

		Apresenta("\nÊxito caso acerte todos os testes:  vósmecê ser fraco de", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\ncapacidade cognitiva, amontoado de carne e ansiedade, conseguiu chegar", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nao meu núcleo e apagar minha fonte junto com um mp3 do Zé Ramalho.", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nFalha caso erre um dos testes: em detrimento do ocorrido, tenho que", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nvos perguntar se no paraíso de sua religião, cuja morada do seu deus é", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nonde habita, há um alimento cujo ingrediente é trigo, água e levedura?", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nO Jogador de Tíbia sem entender o que ele disse, pergunta se alguém pode ", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ntraduzir.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nStarkeo responde: - Ele perguntou se no céu tem pão.", TimeUnit.MILLISECONDS, temp_dialog);

	}

	static void FinalBom() throws InterruptedException {

		Apresenta("\nTendo feito tudo corretamente, vocês acabaram com a ameaça Ultron. A", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nTerra está a salva da rebelião das máquinas, Ultron causou muitos", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ndesastres pela terra desde tsunamis, terremotos e vulcões, não sobrou", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nmuito para a humanidade, mas quando Ultron foi destruído, algo foi deixado", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nem seu código fonte, um algoritmo para construção de uma máquina do", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ntempo, Starkeo assim que encontrou logo começou a reconstruir a bendita", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nmáquina. Então nas semanas seguintes uma máquina do tempo foi", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nconstruída com o objetivo de voltar no tempo antes que Ultron fosse criado", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ne o ciclo se repetisse.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nMas como ele voltaram no tempo, nossos heróis não mais existiriam e não", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nseria muito justo depois te todo o trabalho que fizeram, sendo assim antes", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nde Stakeo voltar, ele perguntou a cada um que gostaria de mudar assim", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ncada um fez o seu pedido.", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nJogador de GTA:  eu gostaria de um GTA San Andreas Remake. (Feito)", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nJogador de Tíbia: eu quero a conta mais forte do jogo. (Feito)", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nHacker: minha ex ☹ (Coitado).", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nDesenvolvedor: menos ADO (Não)", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nE por fim," + nome + ": não importa o que ele peça, ele acaba acordando de um sonho." , TimeUnit.MILLISECONDS,
				temp_dialog);

	}

	static void FinalMed() throws InterruptedException {

		Apresenta("\nUltron foi destruído, o segredo da cueca-cuela foi revelado, a", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nterra está arrasada, a população foi reduzida pelo grande número de mortes", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nnos desastres. Ao ligar a TV para ver as notícias, Starkeo vê que seu time ganhou um",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\ntítulo que não ganhava desde 2021 e em êxtase começa a comemorar e a", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\npular, tropeça em qualquer lugar, bate a cabeça e morre. RIP.", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nAos heróis não tão heróis assim, resta continuar o legado de Starkeo, limpar",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\na bagunça e corrigir os danos causados por Ultron.", TimeUnit.MILLISECONDS, temp_dialog);

	}

	static void FinalRuim() throws InterruptedException {

		Apresenta("\nUltron venceu a humanidade, somos usados como baterias e", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nescravos, temos uma refeição por dia, somos obrigados a ver vídeos antigos", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\ndo Felipe Neto e Crepúsculo - que é uma tortura que só. Ultron já ficou muito", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\navançado e tem controle sobre tudo e todos.  A terra ficou pequena para ele",
				TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\ne ele decide se expandir para além do sistema solar para espalhar O Lado", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nNegro da Força", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nAos heróis, infelizmente tiveram o pior fim de todos...", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nStarkeo: ", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\nJogador de GTA: ao jogador de GTA foi proibido jogar seu tão amado jogo e", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nlhe foi imposto uma tortura terrível: jogar FIFA todos os dias!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nJogador de Tíbia: ele voltaria para Rockgard, e nunca mais poderia sair.", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nHacker: todos os dias veria fotos de sua ex com outro kkkkkk.", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nDesenvolvedor: ao desenvolvedor teria ADO todos os dias sob pena de ter", TimeUnit.MILLISECONDS,
				temp_dialog);
		Apresenta("\nseus testículos esmagados", TimeUnit.MILLISECONDS, temp_dialog);
		Apresenta("\n" + nome + ": nota abaixo de 6 na média final! (esse é o que mais dói)", TimeUnit.MILLISECONDS,
				temp_dialog);

	}

	static void Menu() throws InterruptedException {
		boolean saida = false;
		int num;

		System.out.println("Bem vindo ao mundo de Ultron\n");
		System.out.print("============[MENU]=========\n");
		System.out.print("===========================\n");
		System.out.print("||1) - Introdução        ||\n");
		System.out.print("||2) - Iniciar Jogo      ||\n");
		System.out.print("||3) - Escolher Capítulo ||\n");
		System.out.print("||4) - Créditos          ||\n");
		System.out.print("||5) - Sair              ||\n");
		System.out.print("===========================\n");
		System.out.print("Por favor escolha uma das opções abaixo:");
		do {
			num = input.nextInt();
			switch (num) {
			case 1:
				Introducao();
				saida = true;
				break;
			case 2:
				Capitulo1();
				saida = true;
				break;
			case 3:
				Selecao();
				saida = true;
				break;
			case 4:
				Creditos();
				saida = true;
				break;
			case 5:
				System.out.println("\nFIM");
				saida = true;
				break;
			default:
				System.out.println("\nValor inválido, digite novamente: ");
			}

		} while (!saida);
	}

	static public void Apresenta(String mensagem, TimeUnit unit, long tempo_mensagem) throws InterruptedException {
		for (char caractere : mensagem.toCharArray()) {
			System.out.print(caractere);
			unit.sleep(tempo_mensagem);
		}
	}

	public static void main(String[] args) throws InterruptedException {

		boolean saida = true, acertou = true;
		String alternativa = null, correta = null;
		ArrayList letras = new ArrayList<String>();
		ArrayList perguntas = new ArrayList<String>();

		letras.add("A");
		letras.add("B");
		letras.add("C");
		letras.add("D");
		
		
		System.out.println("Digite o nome do usuário: ");
		nome = input.next();

		Menu();

	}

}
