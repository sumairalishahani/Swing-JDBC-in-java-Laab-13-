import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.Writer;
import java.sql.*;

class MyFrame extends JFrame  implements ActionListener {
    JLabel label1, label2, label3, label4, label5, label6, label7, label8;
    JTextField name,RollNo,batch,section,country;
    JRadioButton male,female;
    JCheckBox matric,intermediate,graduate,P_graduate;
    JTextArea address;
    JComboBox country_cb;
    JButton save,print,JDBC,Clear;





    public MyFrame() {



        setTitle("Registration Form");
        setSize(700,700);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.YELLOW);
        Container c= getContentPane();


        // Creating labels
        label1 = new JLabel("Name");
        label1.setBounds(20, 20, 200, 20);
        c.add(label1);

        label2=new JLabel("RollNo");
        label2.setBounds(20,80,200,20);
        c.add(label2);

        label3=new JLabel("Batch");
        label3.setBounds(20,140,200,20);
        c.add(label3);

        label4=new JLabel("Section");
        label4.setBounds(20,200,200,20);
        c.add(label4);

        label5=new JLabel("Gender");
        label5.setBounds(20,260,200,20);
        c.add(label5);

        label6=new JLabel("Qualification");
        label6.setBounds(20,320,200,20);
        c.add(label6);

        label7=new JLabel("Address");
        label7.setBounds(20,380,200,20);
        c.add(label7);


        label8=new JLabel("Country");
        label8.setBounds(20,440,200,20);
        c.add(label8);

        // Creating textField
        name=new JTextField();
        name.setBounds(100,20,200,20);
        c.add(name);

        RollNo=new JTextField();
        RollNo.setBounds(100,80,200,20);
        c.add(RollNo);




        batch=new JTextField();
        batch.setBounds(100,140,200,20);
        c.add(batch);


        section=new JTextField();
        section.setBounds(100,200,200,20);
        c.add(section);



        //RadioButton for gender
        male=new JRadioButton("Male");
        male.setBounds(100,260,150,20);

        female=new JRadioButton("Female");
        female.setBounds(200,260,150,20);
        c.add(male);
        c.add(female);

        ButtonGroup g=new ButtonGroup();
        g.add(male);
        g.add(female);

        //CheckBox for Qualification
        matric=new JCheckBox("Matric");
        matric.setBounds(100,320,200,20);

        intermediate=new JCheckBox("Intermidate");
        intermediate.setBounds(200,320,200,20);

        graduate=new JCheckBox("Graduate");
        graduate.setBounds(100,340,200,20);

        P_graduate=new JCheckBox("Post Graduate");
        P_graduate.setBounds(200,340,200,20);
        //Checkbox F=new Checkbox();
        c.add(matric);
        c.add(intermediate);
        c.add(graduate);
        c.add(P_graduate);

        //textArea for Address
        address=new JTextArea();
        address.setBounds(100,380,200,40);
        c.add(address);

        //ComboBox for List of Countries
        String[] Country={"Pakistan","China","India","Afganistan","Iran","UAE"};
        country_cb = new JComboBox(Country);
        country_cb.setBounds(100,440,200,20);
        c.add(country_cb);




        // Save,print,JDBC
        save=new JButton("Save");
        save.setBounds(100,500,100,30);
        c.add(save);


        print=new JButton("Print");
        print.setBounds(250,500,100,30);
        c.add(print);

        JDBC=new JButton("JDBC");
        JDBC.setBounds(400,500,100,30);
        c.add(JDBC);

        Clear=new JButton("Clear");
        Clear.setBounds(550,500,100,30);
        c.add(Clear);



        save.addActionListener(this );
        print.addActionListener(this);
        JDBC.addActionListener(this);
        Clear.addActionListener(this);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        JSONObject obj = new JSONObject();
        obj.put("Name", name.getText());
        obj.put("RollNo: ", RollNo.getText());
        obj.put("Batch: ", batch.getText());
        obj.put("Section: ", section.getText());



        if(male.isSelected()){
            obj.put("gender",male.getText());

        }else {
            obj.put("gender",female.getText());
        } obj.put("Address",  address.getSelectedText());
        obj.put("Country",country_cb.getSelectedItem());

        if(e.getSource()==save){

            try {
                Writer writer = new FileWriter("OutPut.json");
                writer.write(obj.toJSONString());
                try{
                    if(male.isSelected()) {
                        obj.put("Gender: ", male.getText());
                    }
                    else {
                        obj.put("Gender: ", female.getText());
                    }
                }
                catch (Exception ie){
                    ie.printStackTrace();
                }

                writer.close();
            } catch (Exception ie) {
                ie.printStackTrace();
            }
            try {


                if(matric.isSelected())
                    obj.put("Qualification",matric.getText());
                else if (intermediate.isSelected()) {
                    obj.put("Qualification",intermediate.getText());

                } else if (graduate.isSelected()) {
                    obj.put("Qualification",graduate.getText());

                }else {
                    obj.put("Qualification",P_graduate.getText());
                }}catch (Exception r){

            }


        }
        if(e.getSource()==print) {

            setTitle("Information Form");
            setSize(600, 600);
            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            getContentPane().setBackground(Color.ORANGE);
            name.getText();
            RollNo.getText();
            batch.getText();
            section.getText();
            country_cb.getSelectedObjects();
            if (male.isSelected())
                male.getText();
            else
                female.getText();
        }
        try {


            if (matric.isSelected())
                matric.getText();
            else if (intermediate.isSelected()) {
                intermediate.getText();

            } else if (graduate.isSelected()) {
                graduate.getText();
            } else {
                P_graduate.getText();
            }
            address.getSelectedText();
            country_cb.getSelectedItem();
        }catch (Exception f){

        }
        if (e.getSource()==JDBC) {
            String N = name.getText();
            String R = RollNo.getText();
            String B = batch.getText();
            String S = section.getText();
            String G;

            if (male.isSelected())
                G = male.getText();
            else
                G = female.getText();


            String Q;


            if (matric.isSelected())
                Q = matric.getText();
            else if (intermediate.isSelected()) {
                Q = intermediate.getText();

            } else if (graduate.isSelected()) {
                Q = graduate.getText();
            } else {
                Q = P_graduate.getText();
            }
            String A = address.getSelectedText();
            String co = country_cb.getSelectedItem().toString();
            try {


                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_registration_form", "root", "1234");
                String q = "insert into s_registration(N,R,B,S,G,Q,A,co) values(?,?,?,?,?,?,?,?)";
                PreparedStatement st = con.prepareStatement(q);
                st.executeUpdate(q);

                st.setString(1, N);
                st.setString(2, R);
                st.setString(3, B);
                st.setString(4, S);
                st.setString(5, G);
                st.setString(6, Q);
                st.setString(7, A);
                st.setString(8, co);

                st.execute();



            } catch (Exception exception) {
                exception.printStackTrace();

            }
        }

        if(e.getSource()==Clear){

               name.setText("");
               RollNo.setText("");
               batch.setText("");
               section.setText("");
//               male.setText("");
//               female.setText(" ");

                if (matric.isSelected())
                     matric.setSelected(false);
                else if (intermediate.isSelected()) {
                     intermediate.setText("");

                } else if (graduate.isSelected()) {
                     graduate.setText("");
                } else {
                     P_graduate.setText("");
                }
                 address.setText("");
                 country_cb.setSelectedIndex(0);




    }

}}
class Student_Registration_Form {
    public static void main(String[] args) {

        MyFrame b = new MyFrame();

    }
}