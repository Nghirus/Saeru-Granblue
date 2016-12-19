package ferranflacar.saerugranbluesimple;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.xwalk.core.XWalkNavigationHistory;
import org.xwalk.core.XWalkView;

public class MainActivity extends AppCompatActivity {
    private XWalkView xWalkWebView;
    private Button bt1,bt2,bt3;
    private ImageView ivBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TraerReferencias();
        ButtonListener();
        Load();
    }

    private void Load() {
        xWalkWebView=(XWalkView)findViewById(R.id.xwalkWebView);
        xWalkWebView.getSettings().setJavaScriptEnabled(true);
        xWalkWebView.load("http://gbf.game.mbga.jp", null);
    }

    private void TraerReferencias(){
        bt1 = (Button)findViewById(R.id.bt_back);
        bt1.setBackgroundColor(Color.TRANSPARENT);
        bt2 = (Button)findViewById(R.id.bt_reload);
        bt2.setBackgroundColor(Color.TRANSPARENT);
        bt3 = (Button)findViewById(R.id.bt_mypage);
        bt3.setBackgroundColor(Color.TRANSPARENT);
        ivBar = (ImageView)findViewById(R.id.imageView);
    }
    private void ButtonListener(){
        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                xWalkWebView.getNavigationHistory().navigate(XWalkNavigationHistory.Direction.BACKWARD, 1);
            }});
        bt1.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    ivBar.setImageResource(R.drawable.reloadbar_gbf_back);
                }
                else{
                    ivBar.setImageResource(R.drawable.reloadbar_gbf);
                }
                return false;
            }});
        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                xWalkWebView.reload(0);
            }});
        bt2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    ivBar.setImageResource(R.drawable.reloadbar_gbf_reload);
                }
                else{
                    ivBar.setImageResource(R.drawable.reloadbar_gbf);
                }
                return false;
            }});
        bt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                xWalkWebView.load("http://gbf.game.mbga.jp/#mypage", null);
            }});
        bt3.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    ivBar.setImageResource(R.drawable.reloadbar_gbf_mypage);
                }
                else{
                    ivBar.setImageResource(R.drawable.reloadbar_gbf);
                }
                return false;
            }});
    }
}
