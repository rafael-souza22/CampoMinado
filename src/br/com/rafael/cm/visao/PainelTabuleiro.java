package br.com.rafael.cm.visao;

import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.com.rafael.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {

	public PainelTabuleiro(Tabuleiro tabuleiro) {
		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

		tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
		tabuleiro.registrarObservador(e -> {
			SwingUtilities.invokeLater(() -> {
				if (e) {
					JOptionPane.showMessageDialog(this, "Parabéns, você Ganhou! =) ");
				} else {
					JOptionPane.showMessageDialog(this, "Que pena, você Perdeu! =( ");
				}
				
				// TODO Perguntar se o jogador quer jogar novamente
				
				/*private void executarJogo() {
					try {
						boolean continuar = true;

						while (continuar) {
							cicloDoJogo();

							System.out.println("Outra partida? (S/n) ");
							String resposta = sc.nextLine();

							if ("n".equalsIgnoreCase(resposta)) {
								continuar = false;
							} else {
								tabuleiro.reiniciar();
							}
						}
					} catch (SairException e) {
						System.out.println("Tchau!!!");
					} finally {
						sc.close();
					}
				}
				*/
				
				tabuleiro.reiniciar();
			});
		});
	}
}