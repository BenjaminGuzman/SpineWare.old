package user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import spineware.LF;

/**
 *
 * @author Mr. Robot
 */
public class Instructions extends JDialog{
        public Instructions(JFrame parent){
            super(parent, true);
            this.setUndecorated(true);
            initComponents(parent);
            this.setTitle("SpineWare - Instrucciones registro");
            this.setLocationRelativeTo(parent);
            this.setVisible(true);
        }
        private void initComponents(JFrame parent){
            this.getContentPane().setBackground(LF.NATIVE);
            this.getContentPane().setLayout(new BorderLayout());
            JLabel instructions[] = instructions();
            JPanel content = new JPanel();
            content.setLayout(new GridLayout(6, 1, 10, 10));
            content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            content.setBackground(LF.NATIVE);
            int i = 0;
            Font ARIAL = new Font("Arial", Font.PLAIN, 20);
            Color FG = new Color(210, 210, 210);
            Border BORDER = BorderFactory.createEmptyBorder(10, 5, 5, 5);
            while(i < 6){
                personalize(instructions[i], ARIAL, FG, BORDER);
                content.add(instructions[i++]);
            }
            JButton JBTN_CLOSE = new JButton("Ok");
            this.getContentPane().add(content, BorderLayout.CENTER);
            this.getContentPane().add(createButtonPanel(JBTN_CLOSE), BorderLayout.SOUTH);
            this.getRootPane().setDefaultButton(JBTN_CLOSE);
            this.setUndecorated(true);
            JBTN_CLOSE.addActionListener((ActionEvent evt) -> {
                this.dispose();
            });
            this.pack();
            this.setLocationRelativeTo(parent);
        }
        private JLabel[] instructions(){
            JLabel inst[] = new JLabel[6];
            inst[0] = new JLabel("A continuaci??n se te tomar??n fotos que servir??n como base para reconocerte cuando inicies sesi??n.");
            inst[1] = new JLabel("Trata de aportar diversas posiciones, muecas, etc??tera para entrenar que te reconozca mejor.");
            inst[2] = new JLabel("El bot??n que acabas de presionar se convertir?? en el temporizador, as?? podr??s ver cu??ntos segundos faltan.");
            inst[3] = new JLabel("<html>Arriba del bot??n \"Registrar\" se mostrar?? si se detectan m??ltiples caras o si no se detecta alguna,<br />procura que colocarte de tal forma que no se muestren estos mensajes.</html>");
            inst[4] = new JLabel("<html>Ser??n 20 segundos los que tendr??s para tomarte las fotos, si ves un poco de retardo o \"lag\" en la imagen,<br/>no te preocupes pues es normal.</html>");
            inst[5] = new JLabel("<html>Posteriormente se generar?? un archivo xml para reconocerte posteriormente, esto puede tomar unos pocos minutos.</html>");
            return inst;
        }
        private JPanel createButtonPanel(JButton JBTN_CLOSE){
            //JBTN_CLOSE.setFont(BTN_FONT);
            JBTN_CLOSE.setFont(LF.FONT_BTN);
            JBTN_CLOSE.setBackground(LF.BG_BTN);
            JBTN_CLOSE.setForeground(LF.FG_BTN);
            JBTN_CLOSE.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            JBTN_CLOSE.setFocusPainted(false);
            
            JPanel JPBTN = new JPanel();
            JPBTN.add(JBTN_CLOSE);
            JPBTN.setBackground(LF.NATIVE);
            return JPBTN;
        }
        private void personalize(JLabel jl, Font ARIAL, Color FG, Border BORDER){
            jl.setForeground(FG);
            jl.setFont(ARIAL);
            jl.setBorder(BORDER);
        }
    }
