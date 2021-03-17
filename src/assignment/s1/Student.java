package assignment.s1;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Student {
    public TextField name;
    public TextField age;
    public TextField mark;
    public TextArea ds;
    public Text txtValidate;

    private ArrayList<String> danhSachSV = new ArrayList<>();

    public void submit(){
        String n = name.getText();
        String l = age.getText();
        String e = mark.getText();

        if (!n.isEmpty() && !e.isEmpty()){
            danhSachSV.add(n+"--"+l+"--"+e);
            String txt = "";
            for (String s : danhSachSV){
                txt += s+"\n";
            }
            name.setText("");
            age.setText("");
            mark.setText("");
            txtValidate.setText("");
            ds.setText(txt);
        }else {
            txtValidate.setText("vui lòng nhập đầy đủ thông tin");
            txtValidate.setDisable(false);
        }
    }

}
