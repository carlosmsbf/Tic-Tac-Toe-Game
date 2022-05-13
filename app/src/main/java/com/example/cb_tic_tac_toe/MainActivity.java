package com.example.cb_tic_tac_toe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private int playerQuantity;
    private int player;
    private int mat[][] = new int[3][3];
    private Button btnMatch[] = new Button[9];
    private String winner;
    private String playerNameOne="Player One";
    private String playerNameTwo="Player Two";
    private boolean isTrue = false;
    private Button btnNewGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player = 1;
        captureButtonId();
        disableButtons();




        btnMatch[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerMove(btnMatch[0], 0, 0);
                btnMatch[0].setEnabled(false);
            }
        });

        btnMatch[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerMove(btnMatch[1], 0, 1);
                btnMatch[1].setEnabled(false);

            }
        });

        btnMatch[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerMove(btnMatch[2], 0, 2);
                btnMatch[2].setEnabled(false);

            }
        });

        btnMatch[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerMove(btnMatch[3], 1, 0);
                btnMatch[3].setEnabled(false);
            }
        });

        btnMatch[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerMove(btnMatch[4], 1, 1);
                btnMatch[4].setEnabled(false);
            }
        });

        btnMatch[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerMove(btnMatch[5], 1, 2);
                btnMatch[5].setEnabled(false);
            }
        });

        btnMatch[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerMove(btnMatch[6], 2, 0);
                btnMatch[6].setEnabled(false);

            }
        });

        btnMatch[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerMove(btnMatch[7], 2, 1);
                btnMatch[7].setEnabled(false);
            }
        });

        btnMatch[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerMove(btnMatch[8], 2, 2);
                btnMatch[8].setEnabled(false);
            }
        });


        btnNewGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                    eraseGame();
                    TextView tvMT = (TextView) findViewById(R.id.txtMatchTracker);
                    getWindow().getDecorView().setBackgroundColor(Color.LTGRAY);
                    tvMT.setText(playerNameOne+ "'s turn!!");
                    playerQuantity = 1;

            }
        });


    }




    public void disableButtons() {
        for (int i = 0; i < 9; i++) {
            btnMatch[i].setEnabled(false);
        }
        TextView tvMT = (TextView) findViewById(R.id.txtMatchTracker);
        tvMT.setText("");
    }

    public void captureButtonId() {

        btnMatch[0] = findViewById(R.id.button00);
        btnMatch[1] = findViewById(R.id.button01);
        btnMatch[2] = findViewById(R.id.button02);
        btnMatch[3] = findViewById(R.id.button10);
        btnMatch[4] = findViewById(R.id.button11);
        btnMatch[5] = findViewById(R.id.button12);
        btnMatch[6] = findViewById(R.id.button20);
        btnMatch[7] = findViewById(R.id.button21);
        btnMatch[8] = findViewById(R.id.button22);
        btnNewGame = findViewById(R.id.btnNewGame);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //




    // Another Option
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.playersNameChanger:


              //

                        final EditText editText2 = new EditText(this);
                    AlertDialog.Builder secondPlayer = new AlertDialog.Builder(this);
                    secondPlayer.setMessage("Please, write the second player name: ");
                    secondPlayer.setTitle("Player 2");
                    secondPlayer.setView(editText2);
                secondPlayer.setIcon(android.R.drawable.ic_menu_edit);
                    secondPlayer.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                                playerNameTwo = editText2.getText().toString();
                            TextView tvTwo = (TextView) findViewById(R.id.txtPlayerTwo);
                            tvTwo.setText(playerNameTwo);

                        }
                    });
                    secondPlayer.create();
                    secondPlayer.show();

    final EditText editText = new EditText(this);
    AlertDialog.Builder firstPlayer = new AlertDialog.Builder(this);
    firstPlayer.setMessage("Please, write the first player name: ");
    firstPlayer.setTitle("Player 1");
    firstPlayer.setView(editText);
                firstPlayer.setIcon(android.R.drawable.ic_menu_edit);
    firstPlayer.setPositiveButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

                playerNameOne = editText.getText().toString();
            TextView tvOne = (TextView) findViewById(R.id.txtPlayerOne);
            tvOne.setText(playerNameOne);
        }
    });


    firstPlayer.create();
    firstPlayer.show();

                    break;



            case R.id.information:
                AlertDialog.Builder informationAlert = new AlertDialog.Builder(this);

                informationAlert.setTitle("Information");
                informationAlert.setMessage("\n\n" +" RULES FOR TIC-TAC-TOE\n" +
                                "\n" +
                                "1. The game is played on a grid that's 3 squares by 3 squares.\n" +
                                "\n" +
                                "2. You are X, your friend (or the computer in this case) is O. Players take turns putting their marks in empty squares.\n" +
                                "\n" +
                                "3. The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.\n" +
                                "\n" +
                                "4. When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie. ");
                informationAlert.setIcon(android.R.drawable.ic_dialog_info);
                informationAlert.create();
                informationAlert.show();


                break;

        }
        player = 1;
        statusMessage();
        player = 2;
        return super.onOptionsItemSelected(item);
    }

    public void playerMove(Button btnSelected, int firstSlot, int secondSlot) {
        btnSelected.setEnabled(true);
        if (player == 1) {
            mat[firstSlot][secondSlot] = 1;
            btnSelected.setText("X");
            statusMessage();
            player = 2;
            winner = playerNameOne;
            matchCheker(1);
        } else {
            mat[firstSlot][secondSlot] = 2;
            btnSelected.setText("O");
            statusMessage();
            player = 1;
            winner = playerNameTwo;
            matchCheker(2);

        }
        playerQuantity++;
    }

    public boolean matchVictory(int slotChecker) {

        for (int i = 0; i < mat.length; i++) {

            if (mat[i][0] == slotChecker && mat[i][1] == slotChecker && mat[i][2] == slotChecker) {
                return true;
            }
            if (mat[0][i] == slotChecker && mat[1][i] == slotChecker && mat[2][i] == slotChecker) {
                return true;
            }
        }
        if (mat[0][0] == slotChecker && mat[1][1] == slotChecker && mat[2][2] == slotChecker) {
            return true;
        }
        if (mat[0][2] == slotChecker && mat[1][1] == slotChecker && mat[2][0] == slotChecker) {
            return true;
        }

        return false;

    }

    public void matchCheker(int checker) {

        if (matchVictory(checker) == true) {

            AlertDialog.Builder winnerAlert = new AlertDialog.Builder(this);
            winnerAlert.setTitle("Victory");
            winnerAlert.setMessage("Congratulations, " + winner + " won!!!!");
            winnerAlert.setIcon(android.R.drawable.ic_menu_mylocation);
            winnerAlert.setPositiveButton("OK", null);
            winnerAlert.create();
            winnerAlert.show();
            endOfGame();
            TextView tvStatus = (TextView) findViewById(R.id.txtMatchTracker);
            tvStatus.setText(winner +" won!!");
            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
            playerQuantity=1;


        }
        else{
            if( playerQuantity == 9) {
                AlertDialog.Builder winnerAlert = new AlertDialog.Builder(this);
                winnerAlert.setTitle("TIE");
                winnerAlert.setMessage("TIE!!!");
                winnerAlert.setIcon(android.R.drawable.ic_menu_mylocation);
                winnerAlert.setPositiveButton("OK", null);
                winnerAlert.create();
                winnerAlert.show();
                endOfGame();
                TextView tvStatus = (TextView) findViewById(R.id.txtMatchTracker);
                tvStatus.setText("TIE!!!");
                getWindow().getDecorView().setBackgroundColor(Color.WHITE);
                playerQuantity=1;
            }
        }

    }

    public void endOfGame() {
        for (int i = 0; i < 9; i++) {
            btnMatch[i].setEnabled(false);
        }
    }

    public void eraseGame() {
        for (int i = 0; i < 9; i++) {
            btnMatch[i].setEnabled(true);
            btnMatch[i].setText("");
        }

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                mat[x][y] = 0;
            }
        }
        player = 1;
        winner = "";
    }

    public void statusMessage(){
        if(player == 1) {

                TextView tvStatus = (TextView) findViewById(R.id.txtMatchTracker);
                tvStatus.setText(playerNameTwo+ "'s turn!!");


        }
        else{

                TextView tvStatus = (TextView) findViewById(R.id.txtMatchTracker);
                tvStatus.setText(playerNameOne + "'s turn!!");


        }



    }

}