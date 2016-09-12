package com.example.haseyuuki.fujitsuchizaihase;

/**
 * Created by TAKUYA on 2016/09/11.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


public class UserRegist extends Activity {

    String bornin;
    String sex;
    String country;

    int sexnum;

 //   FujitsuAPI fujitsuAPI = new FujitsuAPI();

   // FujitsuAPI.Users users = fujitsuAPI.new Users();



    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregist);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ItoA itoa = new ItoA();  //itoa関連はバグが多い 「Build」から「Clean Project」でたぶん直る。
        for (int i = 1900; i <= 2016; i++){
            adapter.add(itoa.convert(i,10));
        }

        Spinner spinner_year = (Spinner) findViewById(R.id.years);
        spinner_year.setAdapter(adapter);



        spinner_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {  //生まれた年の選択
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Spinner spinner = (Spinner) parent;
                // 選択されたアイテムを取得します
                bornin  = (String) spinner.getSelectedItem();
                //Toast.makeText(UserRegist.this, bornin, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        // 指定した ID のラジオボタンをチェックします
        // チェックされているラジオボタンの ID を取得します
        RadioButton radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        // ラジオグループのチェック状態が変更された時に呼び出されるコールバックリスナーを登録します
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {  //性別の選択
            // ラジオグループのチェック状態が変更された時に呼び出されます
            // チェック状態が変更されたラジオボタンのIDが渡されます
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                sexnum = checkedId;

//                sex = (String) radioButton.getText();
                //Toast.makeText(UserRegist.this,"onCheckedChanged():" + radioButton.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        radioGroup.check(R.id.radioButton_male);


        Spinner spinner_country = (Spinner) findViewById(R.id.country);  //出身国の選択

        spinner_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            //Spinnerのドロップダウンアイテムが選択された時
            public void onItemSelected(AdapterView parent, View viw, int arg2, long arg3) {
                Spinner spinner = (Spinner)parent;
                country = (String)spinner.getSelectedItem();
                //Toast.makeText(UserRegist.this, country, Toast.LENGTH_LONG).show();
            }
            //Spinnerのドロップダウンアイテムが選択されなかった時
            public void onNothingSelected(AdapterView parent) {
            }});

        Button btnHome = (Button)findViewById(R.id.homebutton);  //ホーム画面に戻る
        btnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // ホーム画面に戻る
                Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnRegit = (Button)findViewById(R.id.buttonreg);  //登録する
        btnRegit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 登録画面に移動

                User user = new User();
                user.bornIn = Integer.parseInt(bornin);
                user.country = Countries.toEnum(country);  //文字列を変換
                if(sexnum == R.id.radioButton_male){  //性別を判定　　最後にチェックされたボタンのIDで判定してる(文字列で判定できなかった...)
                    user.sex = Sexes.Male;
                }else if(sexnum == R.id.radioButton_female){
                    user.sex = Sexes.Female;
                }else{
                    user.sex = Sexes.NotApplicable;
                }
// 登録実行
                FujitsuAPI.Users.register(user, new AsyncCallback() {
                    @Override
                    // 登録した結果はコールバック内で処理
                    public void onComplete(String result) {
                        if (result == null) return;
                        try {
                            User res = ParseJson.parseUser(result);
                            Log.d("", "id:" + res.id + " createdAt:" + res.createdAt);
                        } catch (Exception e) { /*何もしないんだよ*/ }
                    }
                });


                Intent intent = new Intent(getApplication(), UserRegistFin.class);
                startActivity(intent);

            }


        });




    }


}
