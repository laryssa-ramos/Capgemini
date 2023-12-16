package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;




public class TicTacToe implements ActionListener{
    
    
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    
    
    TicTacToe(){
        
        //criação e formatação do painel do jogo
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ao fechar a janela do aplicativo, o programa será encerrado corretamente e a execução será finalizada
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50)); //define o fundo do painel de conteúdo da janela frame como uma cor cinza escuro. Qualquer componente adicionado ao painel de conteúdo terá essa cor de fundo, a menos que outra cor seja especificada individualmente para esse componente.
        frame.setLayout(new BorderLayout()); //método da classe JFrame que define o gerenciador de layout para o painel de conteúdo da janela. new BorderLayout(): É uma instância da classe BorderLayout, que é um dos gerenciadores de layout fornecidos pela biblioteca Swing. O BorderLayout organiza os componentes em cinco regiões: norte (North), sul (South), leste (East), oeste (West) e centro (Center).
        frame.setVisible(true); // a janela é tornada visível e exibida na tela. Por outro lado, se você chamar setVisible(false), a janela será ocultada e não será exibida na tela.
        
        //criação e formatação do texto do título
        
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free", Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true); // o fundo será opaco, o que significa que a cor de fundo do componente será visível e não permitirá a passagem de elementos gráficos abaixo dele. Se você chamar setOpaque(false), o fundo será transparente, permitindo que os elementos gráficos abaixo dele sejam visíveis, se houver.
        
        //ciração e formatação do painel do título
        
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100); // É um método da classe Component que define a posição e as dimensões do componente em pixels.
        
        
        //criação e formatação dos botões do jogo
        
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));
        
        
        for(int i = 0; i < 9; i ++){
            
            buttons[i] = new JButton(); //Cria um novo objeto JButton e o armazena na matriz buttons na posição i
            button_panel.add(buttons[i]); //Adiciona o botão recém-criado ao painel 
            buttons[i].setFont(new Font("MV Boli", Font.BOLD,120));
            buttons[i].setFocusable(false);//Define o botão como não focável, o que significa que ele não pode ser selecionado pelo teclado. Isso é útil quando você deseja apenas interações de clique do mouse.
            buttons[i].addActionListener(this); //Adiciona um ouvinte de ação ao botão. Neste caso, o ouvinte está implementado pela classe atua
            
        }
        
        
        title_panel.add(textfield); //adiciona no painel de título o conteúdo do título
        frame.add(title_panel, BorderLayout.NORTH); // coloca o painel de título na parte superior (norte) do painel do jogo
        frame.add(button_panel); //adiciona os botões no painel do jogo
        
        firstTurn(); // chama o método que irá definir quem começa a jogar
    
    }

    @Override  //  Essa anotação é usada para indicar que o método está substituindo ou sobrescrevendo um método da superclasse
    public void actionPerformed(ActionEvent ae) { //Aqui, declaramos o método actionPerformed que recebe um objeto do tipo ActionEvent como parâmetro. Esse objeto contém informações sobre o evento de ação que ocorreu.
        
        for(int i = 0; i < 9; i ++){
            if(ae.getSource() == buttons[i]){ //Verifica se o componente que gerou o evento ae é igual ao botão buttons[i] da iteração atual. Isso significa que estamos verificando se o evento de ação foi gerado por um dos botões do array buttons.
                if(player1_turn){
                    if(buttons[i].getText() == ""){ //Verifica se o texto do botão buttons[i] da iteração atual é vazio. Isso é usado para garantir que o botão não tenha sido preenchido anteriormente, evitando que o jogador sobrescreva a jogada anterior.
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X"); //Define o texto do botão para "X".
                        player1_turn = false; //Altera o valor da variável player1_turn para false, indicando que agora é a vez do jogador 2 (o jogador que joga com "O").
                        textfield.setText("O turn"); // Define o texto de um campo de texto chamado textfield para "O turn", indicando que é a vez do jogador 2.
                        check(); // chama o método para verificar se o jogar "X" venceu
                    }        
                }
   
            else{
                if(buttons[i].getText() == ""){
                    buttons[i].setForeground(new Color(0,0,255));
                    buttons[i].setText("O");
                    player1_turn = true;
                    textfield.setText("X turn");
                    check(); // chama o método para verificar se o jogar "O" venceu
                    }
                }
            }
         }
    }
    
    public void firstTurn(){
        
        try {
            Thread.sleep(5000); //faz o programa pausar por 5000 milissegundos (ou seja, 5 segundos).
        } catch (InterruptedException ex) {
           ex.printStackTrace();
        }
    
        if(random.nextInt(2) == 0){ //gerar um número aleatório 0 ou 1. Isso é feito com o método nextInt(2), que retorna um valor inteiro aleatório entre 0 (inclusivo) e 2 (exclusivo), ou seja, apenas 0 ou 1.
        
            player1_turn = true; //Aqui, definimos a variável player1_turn como true, indicando que o jogador 1 ("X") começará o jogo.
            textfield.setText("X turn"); //Atualizamos um campo de texto chamado textfield para exibir "X turn", indicando que é a vez do jogador 1 ("X") começar.
        
        }
        else{
        
            player1_turn = false; //Aqui, definimos a variável player1_turn como false, indicando que o jogador 2 ("O") começará o jogo.
            textfield.setText("O turn"); //Atualizamos o campo de texto textfield para exibir "O turn", indicando que é a vez do jogador 2 ("O") começar.
        
        }
    
    }
    
    public void check(){
    
     //check "X"
        if(
                (buttons[0].getText() == "X") &&
                (buttons[1].getText() == "X") &&
                (buttons[3].getText() == "X")
                
                ){
        
             xWins(0,1,2);
        
        
        }
        
        if(
                (buttons[3].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[5].getText() == "X")
                
                ){
        
             xWins(3,4,5);
        
        
        }
        
        if(
                (buttons[6].getText() == "X") &&
                (buttons[7].getText() == "X") &&
                (buttons[8].getText() == "X")
                
                ){
        
             xWins(6,7,8);
        
        
        }
        if(
                (buttons[0].getText() == "X") &&
                (buttons[3].getText() == "X") &&
                (buttons[6].getText() == "X")
                
                ){
        
             xWins(0,3,6);
        
        
        }
        if(
                (buttons[1].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[7].getText() == "X")
                
                ){
        
             xWins(1,4,7);
        
        
        }
        if(
                (buttons[2].getText() == "X") &&
                (buttons[5].getText() == "X") &&
                (buttons[8].getText() == "X")
                
                ){
        
             xWins(2,5,8);
        
        
        }
        if(
                (buttons[0].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[8].getText() == "X")
                
                ){
        
             xWins(0,4,8);
        
        
        }
        if(
                (buttons[2].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[6].getText() == "X")
                
                ){
        
             xWins(2,4,6);
        
        
        }
        
        //check "O"
        
           if(
                (buttons[0].getText() == "O") &&
                (buttons[1].getText() == "O") &&
                (buttons[3].getText() == "O")
                
                ){
        
             oWins(0,1,2);
        
        
        }
        
        if(
                (buttons[3].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[5].getText() == "O")
                
                ){
        
             oWins(3,4,5);
        
        
        }
        
        if(
                (buttons[6].getText() == "O") &&
                (buttons[7].getText() == "O") &&
                (buttons[8].getText() == "O")
                
                ){
        
             oWins(6,7,8);
        
        
        }
        if(
                (buttons[0].getText() == "O") &&
                (buttons[3].getText() == "O") &&
                (buttons[6].getText() == "O")
                
                ){
        
             oWins(0,3,6);
        
        
        }
        if(
                (buttons[1].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[7].getText() == "O")
                
                ){
        
             oWins(1,4,7);
        
        
        }
        if(
                (buttons[2].getText() == "O") &&
                (buttons[5].getText() == "O") &&
                (buttons[8].getText() == "O")
                
                ){
        
             oWins(2,5,8);
        
        
        }
        if(
                (buttons[0].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[8].getText() == "O")
                
                ){
        
             oWins(0,4,8);
        
        
        }
        if(
                (buttons[2].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[6].getText() == "O")
                
                ){
        
             oWins(2,4,6);
        
        
        }

    
    }
    
    public void xWins(int a, int b, int c){
        
        buttons[a].setBackground(   Color.GREEN);
        buttons[b].setBackground(   Color.GREEN);
        buttons[c].setBackground(   Color.GREEN);
        
        for(int i = 0; i < 9; i ++){
            buttons[i].setEnabled(false); //É um método da classe JButton que permite habilitar ou desabilitar o botão. Quando você chama setEnabled(false), o botão fica desabilitado, o que significa que o usuário não pode interagir com ele.
        }
        textfield.setText("X wins!");
    }
    
    
    public void oWins(int a, int b, int c){
        
        buttons[a].setBackground(   Color.GREEN);
        buttons[b].setBackground(   Color.GREEN);
        buttons[c].setBackground(   Color.GREEN);
        
        for(int i = 0; i < 9; i ++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins!");
        
    }
    
    
    
    
}
