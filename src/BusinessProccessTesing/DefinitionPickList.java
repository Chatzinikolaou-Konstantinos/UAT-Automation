package BusinessProccessTesing;

import BusinessProccessTesing.Definitions.Definition;

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DefinitionPickList {

    public JFrame frame = new JFrame("Automated BP Creation");
    public JPanel panelWest = new JPanel();
    public JPanel panelEast = new JPanel();
    public JPanel panelNorth = new JPanel();
    public JPanel panelSouth = new JPanel();
    public JPanel panelCenter = new JPanel() {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(380, 300);
        }
    };
    public JButton button  = new JButton("Generate Busines Proccess"); 

    public DefinitionPickList() throws Exception{
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panelWest, BorderLayout.WEST);
        frame.add(panelEast, BorderLayout.EAST);
        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelSouth, BorderLayout.SOUTH);

        final DefaultListModel<String> options = new DefaultListModel<>();
        Definition[] Defs = Definition.values();
        for (Definition definition : Defs) {
            options.addElement(definition.name());
        }

        final JList<String> list = new JList<>(options);  
        list.setBounds(100,100, 250,(18*Defs.length));
        button.setBounds(100, 70, 250, 30);

        panelCenter.add(list);
        panelCenter.add(button);
        panelCenter.setBackground(Color.WHITE);

        frame.add(panelCenter);
        frame.pack();
        frame.setLocation(150, 150);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        /**
         * Inside the action listener we call the RunBPs,
         * with the definition we want to run the "main" programm
         */
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {   
                if (list.getSelectedIndex() != -1) {
                    try {
                        Definition definition = Defs[list.getSelectedIndex()];
                        
                        //we dont want the closing window to terminate the programm
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

                        new RunBPs(definition);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }  
        });
    }
}