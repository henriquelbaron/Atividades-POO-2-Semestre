/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.br.com;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import javax.swing.*;

/**
 *
 * @author Alunos
 */
public class Cliente extends JFrame implements ActionListener, KeyListener {
    
    private static final long serialVersionVID = 1L;
    private JTextArea texto;
    private JTextField txtMsg;
    private JButton btnSend;
    private JButton btnSair;
    private JLabel lblHistorico;
    private JLabel lblMsg;
    private JPanel pnlContent;
    private Socket socket;
    private OutputStream out;
    private Writer ouw;
    private BufferedWriter bfw;
    private JTextField txtIP;
    private JTextField txtPorta;
    private JTextField txtNome;
    
    public Cliente() throws IOException {
        JLabel lblMensagem = new JLabel("Verificar!");
        txtIP = new JTextField("localhost");
        txtPorta = new JTextField("12345");
        txtNome = new JTextField("Cliente");
        Object[] texts = {lblMensagem, txtIP, txtPorta, txtNome};
        JOptionPane.showMessageDialog(null, texts);
        pnlContent = new JPanel();
        texto = new JTextArea(10, 20);
        texto.setBackground(Color.blue);
        txtMsg = new JTextField(20);
        lblHistorico = new JLabel("Histórico");
        lblMsg = new JLabel("Mensagem");
        btnSend = new JButton("Enviar");
        btnSend.setToolTipText("Enviar Mensagem");
        btnSair = new JButton("Sair");
        btnSair.setToolTipText("Sair do Chat");
        btnSend.addActionListener(this);
        btnSair.addActionListener(this);
        btnSend.addKeyListener(this);
        txtMsg.addKeyListener(this);
        JScrollPane scroll = new JScrollPane(texto);
        texto.setLineWrap(true);
        pnlContent.add(lblHistorico);
        pnlContent.add(scroll);
        pnlContent.add(lblMsg);
        pnlContent.add(txtMsg);
        pnlContent.add(btnSair);
        pnlContent.add(btnSend);
        pnlContent.setBackground(Color.LIGHT_GRAY);
        texto.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLUE));
        txtMsg.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLUE));
        setTitle(txtNome.getText());
        setContentPane(pnlContent);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(250, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void conectar() throws IOException {
        socket = new Socket(txtIP.getText(), Integer.parseInt(txtPorta.getText()));
        out = socket.getOutputStream();
        ouw = new OutputStreamWriter(out);
        bfw = new BufferedWriter(ouw);
        bfw.write(txtNome.getText() + "\r\n");
        bfw.flush();
    }
    
    public void enviarMensagem(String msg) throws IOException {
        if (msg.equals("Sair")) {
            bfw.write("Desconectado \r\n");
            texto.append("Desconectado \r\n");
        } else {
            bfw.write(msg + "\r\n");
            texto.append(txtNome.getText() + " diz -> " + txtMsg.getText() + "\r\n");
        }
        bfw.flush();
        txtMsg.setText("");
    }
    
    public void escutar() throws IOException {
        
        InputStream in = socket.getInputStream();
        InputStreamReader inr = new InputStreamReader(in);
        BufferedReader bfr = new BufferedReader(inr);
        String msg = "";
        
        while (!"Sair".equalsIgnoreCase(msg)) {
            
            if (bfr.ready()) {
                msg = bfr.readLine();
                if (msg.equals("Sair")) {
                    texto.append("Servidor caiu! \r\n");
                } else {
                    texto.append(msg + "\r\n");
                }
            }
        }
    }
    
    
    public void sair()throws IOException{
        
        enviarMensagem("Sair");
        bfw.close();
        ouw.close();
        out.close();
        socket.close();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand().equals(btnSend.getActionCommand())) {
                enviarMensagem(txtMsg.getText());
            }else{
                if(e.getActionCommand().equals(btnSair.getActionCommand())){
                    sair();
                }
            }
        } catch (Exception e1) {
            e1.getMessage();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
