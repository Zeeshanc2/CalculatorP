package com.example.calculatorp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Calculation");
    String[] vOperation;
    TextView st2,st,btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnadd, btnsub, btnmul, btndiv, btndot, btnequals,
            btnclr, btnbck;
    TextView ed1, ed2;
    float Res1, Res2, rslt;
    boolean Add, Sub, Mul, Div;

    String vCal = "" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        st =findViewById( R.id.sc );
        st2=findViewById( R.id.ed2 );
        st.setSelected( true );
        st2.setSelected( true );
        vOperation = new String[100];
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btnadd = findViewById(R.id.btnadd);
        btnsub = findViewById(R.id.btnsub);
        btndiv = findViewById(R.id.btndiv);
        btnmul = findViewById(R.id.btnmul);
        btndot = findViewById(R.id.btndot);
        btnequals = findViewById(R.id.btnequals);
        btnclr = findViewById(R.id.btnclr);
        btnbck = findViewById(R.id.btnbck);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText() + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText() + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText() + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText() + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText() + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText() + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText() + "9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText() + "0");
            }
        });

        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed1.setText(ed1.getText() + ".");

//                String op ;
//                String ed1Check = ed1.getText().toString() ;
//
//                for (int i = 0; i < ed1.length(); i++) {
//                    op = String.valueOf(ed1Check.charAt(i));
//
//                    if (op.compareTo(".") == 0) {
//                        ed1.setText(ed1.getText()+".");
//
//                        break;
//                    }
//                }
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    ed1.setText(ed1.getText() + "+");

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Please Insert Value", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    ed1.setText(ed1.getText() + "-");

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Please Insert Value", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    ed1.setText(ed1.getText() + "*");

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Please Insert Value", Toast.LENGTH_SHORT).show();
                }
            }

        });

        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    ed1.setText(ed1.getText() + "/");

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Please Insert Value", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText("");
                ed2.setText("");
            }
        });

        btnbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    if (!ed1.getText().toString().equals("")) {
                        String Value = ed1.getText().toString();
                        if (Value.length() > 0) {
                            Value = Value.substring(0, Value.length() - 1);
                            ed1.setText(Value);
                        }if (!ed1.getText().toString().equals( "" )){
                            ed2.setText( "" );
                        }
                    }
                } catch (Exception e) {

                }
            }
        });

        TextView history_bt = findViewById(R.id.history_bt);
        history_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,History.class);
                startActivity(intent);

            }
        });
        onEqual();
    }


    public double calculate() {

        String op;
        String vStringValue = ed1.getText().toString();

        String[] arrOfStr = vStringValue.split("[-\\+\\*\\/]");

        for (int i = 0; i < vOperation.length; i++) {
            vOperation[i] = "99999";
        }
        int k = 0;
        for (int i = 0; i < vStringValue.length(); i++) {
            op = String.valueOf(vStringValue.charAt(i));

            if (op.compareTo("+") == 0) {
                vOperation[k] = op;
                k++;
            } else if (op.compareTo("-") == 0) {
                vOperation[k] = op;
                k++;

            } else if (op.compareTo("*") == 0) {
                vOperation[k] = op;
                k++;

            } else if (op.compareTo("/") == 0) {
                vOperation[k] = op;
                k++;
            }
        }

        double vFinalResult = 0;

        for (int j = 0; j < vOperation.length; j++) {
            if (vOperation[j].compareTo("99999") != 0) {

                if (vOperation[j].compareTo("+") == 0) {
                    if (j == 0) {
                        vFinalResult = ((Double.parseDouble(arrOfStr[j]) + Double.parseDouble(arrOfStr[j + 1])));
                    } else {
                        vFinalResult = vFinalResult + ((Double.parseDouble(arrOfStr[j + 1])));
                    }
                } else if (vOperation[j].compareTo("-") == 0) {

                    if (j == 0) {
                        vFinalResult = ((Double.parseDouble(arrOfStr[j]) - Double.parseDouble(arrOfStr[j + 1])));
                    } else {
                        vFinalResult = vFinalResult - ((Double.parseDouble(arrOfStr[j + 1])));
                    }

                } else if (vOperation[j].compareTo("*") == 0) {
                    if (j == 0) {
                        vFinalResult = ((Double.parseDouble(arrOfStr[j]) * Double.parseDouble(arrOfStr[j + 1])));
                    } else {
                        vFinalResult = vFinalResult * ((Double.parseDouble(arrOfStr[j + 1])));
                    }

                } else if (vOperation[j].compareTo("/") == 0) {
                    if (j == 0) {
                        vFinalResult = ((Double.parseDouble(arrOfStr[j]) / Double.parseDouble(arrOfStr[j + 1])));
                    } else {
                        vFinalResult = vFinalResult / ((Double.parseDouble(arrOfStr[j + 1])));
                    }
                }

            }
        }

        String vFinalResult_1 = String.valueOf(vFinalResult);
        vCal = ed1.getText().toString() ;

        if (vFinalResult_1.contains(".0")) {

            vFinalResult = Double.parseDouble(vFinalResult + "");

            int x = (int) Math.round(vFinalResult);
//            ed2.setText(x + "");

            ed2.setText(" " + x + "");

        } else {
//            ed2.setText(vFinalResult+"");
            ed2.setText( "" + vFinalResult );
        }

        return vFinalResult ;

//        ed2.setText("Result ------>>> ( " + vFinalResult + " ) <<<------");
    }

public void onEqual(){
        btnequals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ed2.setText("");
                    calculate();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String currentDateandTime = sdf.format(new Date());
                    ModelClass setDataModel = new ModelClass(String.valueOf(calculate()),currentDateandTime,ed1.getText().toString());
                    String id = myRef.push().getKey();
                    myRef.child(id).setValue(setDataModel);
                    Toast.makeText(MainActivity.this, ""+ed1.getText(), Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Please Check you're values...!", Toast.LENGTH_SHORT).show();
                }
            }
        });
}


}

