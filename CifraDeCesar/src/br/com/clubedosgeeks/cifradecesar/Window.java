package br.com.clubedosgeeks.cifradecesar;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Aplicação "Código de César" * Usa a classe StringBuilder faz parte do pacote
 *            java.lang. Essa classe permite criar e manipular dados de Strings
 *            dinamicamente, ou seja, podem criar variáveis de String
 *            modificáveis.
 * 
 * @author Francisco de Assis de Souza Rodrigues.
 * @Data 17 de maio de 2014.
 * @Site http:www.clubedosgeeks.com.br
 * 
 */
public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame frame;

	/* Usado para criar o campo da mensagem e da chave */
	private JTextArea area_Texto;
	private JTextField ent_chave;

	/**/
	private static Window window;

	/**/
	private String mensagem;
	private int aux_chave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Window.class.getResource("/res/icon.jpg")));
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setTitle("Cifra de César");
		frame.setBounds(100, 100, 450, 420);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();

		JLabel lblChave = new JLabel("Chave:");
		lblChave.setIcon(new ImageIcon(Window.class
				.getResource("/res/chave.png")));

		ent_chave = new JTextField();
		ent_chave.setText("Apenas números!");
		ent_chave.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (ent_chave.getText().equals("Apenas números!")) {
					ent_chave.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (ent_chave.getText().equals("")) {
					ent_chave.setText("Apenas números!");
				}
			}
		});
		ent_chave
				.setToolTipText("A chave é a quantidade de deslocamento.\nInforme um Nº inteiro.\nEx:3");
		ent_chave.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblChave)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(191)
									.addComponent(lblNewLabel))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(ent_chave, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblChave)
							.addComponent(ent_chave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE))
		);

		final JButton btnCriptografar = new JButton("Cifrar");
		btnCriptografar.setBackground(Color.WHITE);
		btnCriptografar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCriptografar.setBackground(new Color(4, 181, 154));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCriptografar.setBackground(Color.WHITE);
			}
		});
		btnCriptografar.setToolTipText("Crifrar a mensagem");
		btnCriptografar.addActionListener(new ActionListener() {
			/**
			 * Cifrar.
			 */
			public void actionPerformed(ActionEvent arg0) {
				/* Tratamento de erro (Condição para realizar ação) */
				if (area_Texto.getText().equals("")
						|| area_Texto.getText().equals("Informe o texto aqui!")) {
					JOptionPane.showMessageDialog(null,
							"Informe o texto a ser Cifrado!");
				} else {
					/*
					 * essa variavel é usada para receber a mensagem informada
					 * da caixa de texto
					 */
					mensagem = area_Texto.getText();

					/* Tratamento de erro (Condição para realizar ação) */
					if (ent_chave.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Informe a chave!");
					} else {
						/* pega o valor da chave em String e converte em Int */
						aux_chave = Integer.valueOf(ent_chave.getText());

						/* Imprime na caixa de texto a mensagem descriptografada */
						area_Texto.setText(cifrar(mensagem, aux_chave));
					}
				}
			}
		});

		final JButton btnDescriptografar = new JButton("Decifrar");
		btnDescriptografar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDescriptografar.setBackground(new Color(4, 181, 154));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDescriptografar.setBackground(Color.WHITE);
			}
		});
		btnDescriptografar.setBackground(Color.WHITE);
		btnDescriptografar.setToolTipText("Decifrar a mensagem");
		btnDescriptografar.addActionListener(new ActionListener() {
			/**
			 * Descifrar.
			 */
			public void actionPerformed(ActionEvent arg0) {
				/* Tratamento de erro (Condição para realizar ação) */
				if (area_Texto.getText().equals("")
						|| area_Texto.getText().equals("Informe o texto aqui!")) {
					JOptionPane.showMessageDialog(null,
							"Informe o texto a ser Decifrado!");
				} else {
					/*
					 * essa variavel é usada para receber a mensagem informada
					 * da caixa de texto
					 */
					mensagem = area_Texto.getText();

					/* Tratamento de erro (Condição para realizar ação) */
					if (ent_chave.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Informe a chave!");
					} else {
						/* pega o valor da chave em String e converte em Int */
						aux_chave = Integer.valueOf(ent_chave.getText());

						/* Imprime na caixa de texto a mensagem descriptografada */
						area_Texto.setText(decifra(mensagem, aux_chave));
					}
				}
			}
		});

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Window.class
				.getResource("/res/logo2.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.TRAILING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED, 210,
								Short.MAX_VALUE)
						.addComponent(btnDescriptografar).addGap(18)
						.addComponent(btnCriptografar).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap(11, Short.MAX_VALUE)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(btnCriptografar)
												.addComponent(
														btnDescriptografar))
								.addContainerGap())
				.addGroup(
						Alignment.LEADING,
						gl_panel.createSequentialGroup().addContainerGap()
								.addComponent(lblNewLabel_1)
								.addContainerGap(23, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		area_Texto = new JTextArea();
		area_Texto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (area_Texto.getText().equals("Informe o texto aqui!")) {
					area_Texto.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (area_Texto.getText().equals("")) {
					area_Texto.setText("Informe o texto aqui!");
				}
			}
		});
		area_Texto.setForeground(Color.BLACK);
		area_Texto.setBackground(Color.WHITE);
		area_Texto.setToolTipText("Informe sua mensagem a ser cifrada");
		scrollPane.setViewportView(area_Texto);
		frame.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnIncio = new JMenu("Início");
		menuBar.add(mnIncio);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnIncio.add(mntmSair);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(
								null,
								"@Cifra de César"
										+ "\n@Versão: 1.0"
										+ "\n@Desenvolvedor: Rodrigues.F.A.S"
										+ "\n@17 de maio de 2014"
										+ "\n@Site: http://www.clubedosgeeks.com.br"
										+ "\n@Para executar:"
										+ "\nVerifique Java Versão: http://www.java.com/en/download/installed.jsp");
			}
		});
		mnAjuda.add(mntmSobre);
	}

	/**
	 * Cifra.
	 * 
	 * @param mensagem
	 * @param chave
	 * @return
	 */
	public static String cifra(String mensagem, int chave) {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < mensagem.length(); i++) {
			char c = (char) (mensagem.charAt(i) + chave);
			builder.append(c);
		}

		return builder.toString();
	}

	/**
	 * Decifra.
	 * 
	 * @param mensagem
	 * @param chave
	 * @return
	 */
	public static String decifra(String mensagem, int chave) {
		return cifra(mensagem, -chave);
	}

	/**
	 * Cifrar.
	 * 
	 * @param mensagem
	 * @param chave
	 * @return
	 */
	public static String cifrar(String mensagem, int chave) {
		return cifra(mensagem, +chave);
	}
}/* FIM CLASS */
