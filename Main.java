package application;

import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Main extends Application {
	Button[][] buttons = new Button[3][3];
	String currentPlayer;
	int Score1 = 0;
	int Score2 = 0;
	int d = 0;

	@Override
	public void start(Stage primaryStage) {
		Pane panmain = new Pane();// interface
		panmain.setStyle("-fx-background-color:black;");
/////////////////////////////////////////////////////////////////Style	
		String font_name = Font.getFamilies().get(25);
		Font font1 = Font.font(font_name, FontWeight.BOLD, FontPosture.REGULAR, 25);
///////////////////////////////////////////////////////////////label
		Label labtitle = new Label("Tic Tac Toe");
		labtitle.setFont(Font.font("Arial", 30));
		labtitle.setTextFill(Color.WHITE);
		labtitle.setFont(font1);
		labtitle.setLayoutX(280);
		labtitle.setLayoutY(10);
//////////////////////////////////////////////////////////////////	label	
		Label labchoose = new Label("Play With:");
		labchoose.setFont(Font.font("Arial", 30));
		labchoose.setTextFill(Color.WHITE);
		labchoose.setFont(font1);
		labchoose.setLayoutX(30);
		labchoose.setLayoutY(350);
////////////////////////////////////////////////////////////////////image
		Image img = new Image("tic2.png");
		ImageView imgV = new ImageView(img);
		imgV.setFitHeight(250);
		imgV.setFitWidth(250);
		imgV.setLayoutX(220);
		imgV.setLayoutY(80);

///////////////////////////////////////////////////////////////////buttons interface
		HBox hbchoose = new HBox(30);
		Button yourfrind = new Button("Your Friend");
		Button computerRandome = new Button("Computer(Randomly)");
		Button ComputerMinMax = new Button("Computer(Unbeatable)");
		yourfrind.setPrefSize(150, 100);
		computerRandome.setPrefSize(150, 100);
		ComputerMinMax.setPrefSize(150, 100);
		hbchoose.getChildren().addAll(yourfrind, computerRandome, ComputerMinMax);
		hbchoose.setLayoutX(80);
		hbchoose.setLayoutY(400);
		// yourfrind.setMaxWidth(250);
		Button Start = new Button("Start");
		panmain.getChildren().addAll(labtitle, imgV, labchoose, hbchoose);
		///////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////// friend action
		///////////////////////////////////////////////////////////////
		yourfrind.setOnAction(e -> {
			Pane start = new Pane();
			panmain.setStyle("-fx-background-color:black;");
			////////////////////////////////
			///////////////////////////////////////////////
			Font myFont6 = Font.font("Your Name: ", FontWeight.BOLD, 12);
			Label lab1 = new Label("Your Name: ");
			lab1.setFont(myFont6);

			TextField tf1 = new TextField();
			tf1.setMaxWidth(200);
			tf1.setMaxHeight(100);
			/////////////////////////////////////////////////////////////
			Font myFont7 = Font.font("Your Friend Name: ", FontWeight.BOLD, 12);
			Label lab2 = new Label("Your Friend Name: ");
			lab2.setFont(myFont7);

			TextField tf2 = new TextField();
			tf2.setMaxWidth(200);
			tf2.setMaxHeight(100);
			//////////////////////////////////////////////////////
			HBox hbstart1 = new HBox(10);
			HBox hbstart2 = new HBox(10);

			VBox vbstart = new VBox(20);
			vbstart.setLayoutX(50);
			vbstart.setLayoutY(100);
			vbstart.getChildren().addAll(hbstart1, hbstart2);
			//////////////////////////////////////////

			///////////////////////////////////////////// player who start
			VBox vbchose = new VBox(10);
			Label labchose = new Label("whose want Start:");
			RadioButton player1name = new RadioButton();
			RadioButton player2name = new RadioButton();
			Label labname1 = new Label("" + tf1.getText());
			Label labname2 = new Label("" + tf2.getText());
			////////////////////////////////////
			HBox hb1chose = new HBox(10);
			hb1chose.getChildren().addAll(player1name, labname1);
			HBox hb2chose = new HBox();
			hb2chose.getChildren().addAll(player2name, labname2);
			////////////////////////////////
			VBox vbchos = new VBox();
			vbchos.getChildren().addAll(hb1chose, hb2chose);
			vbchos.setLayoutX(50);
			vbchos.setLayoutY(200);

			hbstart1.getChildren().addAll(lab1, tf1, hb1chose);
			hbstart2.getChildren().addAll(lab2, tf2, hb2chose);
			//////////////////////////////////////////
			ComboBox cb = new ComboBox();
			cb.getItems().addAll("X", "O");
			vbchose.setLayoutX(50);
			vbchose.setLayoutY(250);
			vbchose.getChildren().addAll(labchose, cb);
			/////////////////////////////////
			Label lab = new Label("how many round you want?");

			TextField roundnum = new TextField();
			VBox vbround = new VBox(10);
			vbround.setLayoutX(150);
			vbround.setLayoutY(250);
			vbround.getChildren().addAll(lab, roundnum);
			///////////////////////////////////////////////////
			Button startbutton = new Button("Start");
			startbutton.setLayoutX(300);
			startbutton.setLayoutY(350);
			/////////////////////////////////////// back
			Button back = new Button("Back");
			back.setLayoutX(20);
			back.setLayoutY(400);
//////////////////////////////////////////			
			Label Labb = new Label("");
			Labb.setLayoutX(70);
			Labb.setLayoutY(400);
			start.getChildren().addAll(vbstart, vbchose, vbchos, startbutton, vbround, back, Labb);
			////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////
			Scene sn1 = new Scene(start, 700, 500);
			Stage stg = new Stage();
			stg.setScene(sn1);
			stg.show();
			primaryStage.close();

			back.setOnAction(w -> {
				stg.close();
				primaryStage.show();
				Labb.setText("");
			});
			///////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////// Start Button
			///////////////////////////////////////////////////////////////
			startbutton.setOnAction(r -> {
				if (tf1.getText().equals("")) {
					Labb.setText("Please write your name");
				} else if (tf2.getText().equals("")) {
					Labb.setText("Please write your friend name");
				} else if (cb.getSelectionModel().isEmpty()) {
					Labb.setText("Please enter whos start");
				} else if (roundnum.getText().equals("")) {
					Labb.setText("Please enter how much round you want");

				} else {
					Pane panplay1 = new Pane();
					GridPane panplay2 = new GridPane();
					panplay2.setAlignment(Pos.CENTER);
					panplay2.setHgap(5);
					panplay2.setVgap(5);
					panplay2.setLayoutX(220);
					panplay2.setLayoutY(110);

					Button reset = new Button("Reset");
					Button changechose = new Button("backToChange");
					reset.setLayoutX(320);
					reset.setLayoutY(450);

//				  changechose.setLayoutX(390);
//				  changechose.setLayoutY(450);
//				  changechose.setOnAction(w->{
//					  
//				  });
					Label labwin = new Label();
					labwin.setLayoutX(260);
					labwin.setLayoutY(80);

					TextArea taplayer1 = new TextArea();
					taplayer1.setLayoutX(5);
					taplayer1.setLayoutY(110);
					taplayer1.setMaxWidth(100);
					taplayer1.setMinHeight(200);
					taplayer1.setStyle("-fx-background-color:transparent");
					////////////////////////////////////////////////
					TextArea taplayer2 = new TextArea();
					taplayer2.setStyle("-fx-background-color:transparent");
					taplayer2.setLayoutX(590);
					taplayer2.setLayoutY(110);
					taplayer2.setMaxWidth(100);
					taplayer2.setMinHeight(200);
					Label labname11 = new Label(tf1.getText() + "\n");
					labname11.setLayoutX(30);
					labname11.setLayoutY(80);
					Label labname22 = new Label(tf2.getText() + "\n");
					labname22.setLayoutX(600);
					labname22.setLayoutY(80);
//  				taplayer1.appendText(tf1.getText()+"\n");
// 				taplayer2.appendText(tf2.getText()+"\n");

					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							Button button = new Button();
							button.setMinSize(100, 100);
							button.setStyle("-fx-font-size: 24");
							buttons[i][j] = button;
							panplay2.add(button, i, j);
							int h = i;
							int u = j;

							button.setOnAction(o -> {
								if (buttons[h][u].getText().equals("")) {
									buttons[h][u].setText(String.valueOf(currentPlayer));

									if (buttons[h][0].getText().equals(String.valueOf(currentPlayer))
											&& buttons[h][1].getText().equals(String.valueOf(currentPlayer))
											&& buttons[h][2].getText().equals(String.valueOf(currentPlayer))) {

										// currentPlayer=currentPlayer;

										if (player1name.isSelected()) {
											if (currentPlayer == cb.getValue()) {
												labwin.setText(tf1.getText() + " wins!");
												Score1++;
												taplayer1.setText("Score:" + Score1);
											} else {
												labwin.setText(tf2.getText() + " wins!");
												Score2++;
												taplayer2.setText("Score:" + Score2);
											}
										} else if (player2name.isSelected()) {
											if (currentPlayer == cb.getValue()) {
												labwin.setText(tf2.getText() + " wins!");
												Score2++;
												taplayer2.setText("Score:" + Score2);

											} else {
												labwin.setText(tf1.getText() + " wins!");
												Score1++;
												taplayer1.setText("Score:" + Score1);
											}
										}

//			         	            					
										buttons[h][0].setTextFill(Color.GREEN);
										buttons[h][1].setTextFill(Color.GREEN);
										buttons[h][2].setTextFill(Color.GREEN);
										for (int k = 0; k < 3; k++) {
											for (int y = 0; y < 3; y++) {
												if (buttons[k][y].getText().equals("")) {
													buttons[k][y].setDisable(true);
												}

											}
										}

									} else if (buttons[0][u].getText().equals(String.valueOf(currentPlayer))
											&& buttons[1][u].getText().equals(String.valueOf(currentPlayer))
											&& buttons[2][u].getText().equals(String.valueOf(currentPlayer))) {
										// System.out.println("Player " + currentPlayer + " wins!");
										if (player1name.isSelected()) {
											if (currentPlayer == cb.getValue()) {
												labwin.setText(tf1.getText() + " wins!");
												Score1++;
												taplayer1.setText("Score:" + Score1);
											} else {
												labwin.setText(tf2.getText() + " wins!");
												Score2++;
												taplayer2.setText("Score:" + Score2);
											}
										} else if (player2name.isSelected()) {
											if (currentPlayer == cb.getValue()) {
												labwin.setText(tf2.getText() + " wins!");
												Score2++;
												taplayer2.setText("Score:" + Score2);

											} else {
												labwin.setText(tf1.getText() + " wins!");
												Score1++;
												taplayer1.setText("Score:" + Score1);
											}
										}

										buttons[0][u].setTextFill(Color.GREEN);
										buttons[1][u].setTextFill(Color.GREEN);
										buttons[2][u].setTextFill(Color.GREEN);
										for (int k = 0; k < 3; k++) {
											for (int y = 0; y < 3; y++) {
												if (buttons[k][y].getText().equals("")) {
													buttons[k][y].setDisable(true);
												}

											}
										}
									}

									else if (h == u && buttons[0][0].getText().equals(String.valueOf(currentPlayer))
											&& buttons[1][1].getText().equals(String.valueOf(currentPlayer))
											&& buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
										// System.out.println("Player " + currentPlayer + " wins!");
										if (player1name.isSelected()) {
											if (currentPlayer == cb.getValue()) {
												labwin.setText(tf1.getText() + " wins!");
												Score1++;
												taplayer1.setText("Score:" + Score1);
											} else {
												labwin.setText(tf2.getText() + " wins!");
												Score2++;
												taplayer2.setText("Score:" + Score2);
											}
										} else if (player2name.isSelected()) {
											if (currentPlayer == cb.getValue()) {
												labwin.setText(tf2.getText() + " wins!");
												Score2++;
												taplayer2.setText("Score:" + Score2);

											} else {
												labwin.setText(tf1.getText() + " wins!");
												Score1++;
												taplayer1.setText("Score:" + Score1);
											}
										}

										buttons[0][0].setTextFill(Color.GREEN);
										buttons[1][1].setTextFill(Color.GREEN);
										buttons[2][2].setTextFill(Color.GREEN);
										for (int k = 0; k < 3; k++) {
											for (int y = 0; y < 3; y++) {
												if (buttons[k][y].getText().equals("")) {
													buttons[k][y].setDisable(true);
												}
											}
										}
									}

									else if (h + u == 2 && buttons[0][2].getText().equals(String.valueOf(currentPlayer))
											&& buttons[1][1].getText().equals(String.valueOf(currentPlayer))
											&& buttons[2][0].getText().equals(String.valueOf(currentPlayer))) {
										// System.out.println("Player " + currentPlayer + " wins!");
										if (player1name.isSelected()) {
											if (currentPlayer == cb.getValue()) {
												labwin.setText(tf1.getText() + " wins!");
												Score1++;
												taplayer1.setText("Score:" + Score1);
											} else {
												labwin.setText(tf2.getText() + " wins!");
												Score2++;
												taplayer2.setText("Score:" + Score2);
											}
										} else if (player2name.isSelected()) {
											if (currentPlayer == cb.getValue()) {
												labwin.setText(tf2.getText() + " wins!");
												Score2++;
												taplayer2.setText("Score:" + Score2);

											} else {
												labwin.setText(tf1.getText() + " wins!");
												Score1++;
												taplayer1.setText("Score:" + Score1);
											}
										}

										buttons[0][2].setTextFill(Color.GREEN);
										buttons[1][1].setTextFill(Color.GREEN);
										buttons[2][0].setTextFill(Color.GREEN);
										for (int k = 0; k < 3; k++) {
											for (int y = 0; y < 3; y++) {
												if (buttons[k][y].getText().equals("")) {
													buttons[k][y].setDisable(true);
												}
											}
										}

									}

									else if (isBoardFull()) {
										showDraw();
									} else {
										if (currentPlayer.equals("X"))
											currentPlayer = "O";
										else
											currentPlayer = "X";
									}
								}
							});

						}
					}

					Label labend = new Label("");
					reset.setOnAction(p -> {
						int X=(Integer.parseInt(roundnum.getText())/2);
//						
						Math.round(X);
						System.out.println(X);
						d++;
						if (d == Integer.parseInt(roundnum.getText())
								|| (Score1 + Score2) == Integer.parseInt(roundnum.getText())) {
							    
							labend.setText("Game End");
							Score1=0;
							Score2=0;
							labend.setFont(Font.font("Arial", 30));
							labend.setTextFill(Color.BLUE);
							labend.setFont(font1);
							labend.setLayoutX(300);
							labend.setLayoutY(450);
							resetGame();
						
							
						
							for (int k = 0; k < 3; k++) {
								for (int y = 0; y < 3; y++) {
									buttons[k][y].setDisable(true);
									labwin.setText("");
									currentPlayer = "" + cb.getValue();
								}

							}
						}
//						
						else if(Score1==X) {
							Score1=0;
							Score2=0;
							labend.setText(tf1.getText()+" is winner");
							
							labend.setFont(Font.font("Arial", 30));
							labend.setTextFill(Color.BLUE);
							labend.setFont(font1);
							labend.setLayoutX(300);
							labend.setLayoutY(20);
							//resetGame();
						}else if(Score2==X) {
                              labend.setText(tf2.getText()+" is winner");
                              Score1=0;
  							Score2=0;
							labend.setFont(Font.font("Arial", 30));
							labend.setTextFill(Color.BLUE);
							labend.setFont(font1);
							labend.setLayoutX(300);
							labend.setLayoutY(20);
							//resetGame();
						}
						else {
							resetGame();
							for (int k = 0; k < 3; k++) {
								for (int y = 0; y < 3; y++) {
									if (buttons[k][y].getText().equals("")) {
										buttons[k][y].setDisable(false);
										buttons[k][y].setTextFill(Color.BLACK);
										labwin.setText("");
										currentPlayer = "" + cb.getValue();
									}
								}
							}
						}
					});

					reset.setLayoutX(500);
					reset.setLayoutY(450);

////////////////////////////////////////////////////back button
					Button back2 = new Button("BackToChange");
					back2.setLayoutX(20);
					back2.setLayoutY(450);
					///////////////////////////////////////////////////////// text field

					//////////////////////////////////////////////////////// vvox to but hbox
					VBox vb = new VBox(10);
					// vb.getChildren().addAll(hb1, hb2, hb3);
					vb.setAlignment(Pos.CENTER);
					vb.setLayoutX(220);
					vb.setLayoutY(110);
					////////////////////////////////////////////////// text area
					;

					// taplayer2.setStyle("-fx-background-color: #fff; -fx-border-color: #fff;
					// -fx-border-width: 0; -fx-border-image-width: 0; -fx-background-image: null;
					// -fx-region-background: null;-fx-border-insets: 0; -fx-background-size:0;
					// -fx-border-image-insets:0;");
					Label labstartxy = new Label(cb.getValue() + "player is start");
					labstartxy.setLayoutX(30);
					labstartxy.setLayoutY(50);

					panplay1.getChildren().addAll(labstartxy, taplayer1, labwin, panplay2, labname11, labname22,
							taplayer2, back2, labend, reset);
					///////////////////////////////////////////////////////////////////////////
					currentPlayer = "" + cb.getValue();
					/////////////////////////////////////////////////////////////////////////
					Scene sn2 = new Scene(panplay1, 700, 500);
					Stage stg1 = new Stage();
					stg1.setScene(sn2);
					stg1.show();
					primaryStage.close();
					stg.close();
					back2.setOnAction(w -> {
						stg1.close();
						stg.show();
					});
				}
			});

		});

		// ****************************************************************************************
		// ****************************************************************************************
//////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////// With
		/////////////////////////////////////////////////////////////////////////////////////////// Computer
		//////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////		
//////////////////////////////////////////////////////////////////////////////
		computerRandome.setOnAction(e -> {
			Pane start = new Pane();
			panmain.setStyle("-fx-background-color:black;");
////////////////////////////////
///////////////////////////////////////////////
			Font myFont6 = Font.font("Your Name: ", FontWeight.BOLD, 12);
			Label lab1 = new Label("Your Name: ");
			lab1.setFont(myFont6);

			TextField tf1 = new TextField();
			tf1.setMaxWidth(200);
			tf1.setMaxHeight(100);

			RadioButton r1name = new RadioButton();
			HBox hbname = new HBox(10);
			hbname.getChildren().addAll(lab1, tf1, r1name);
///////////////////////////////////////////////	
			Label lab2 = new Label("Ai");
			lab2.setFont(myFont6);
			RadioButton r2Ai = new RadioButton();
			HBox hbai = new HBox(30);
			hbai.getChildren().addAll(lab2, r2Ai);
///////////////////////////////////////////
			VBox vb = new VBox(20);
			vb.getChildren().addAll(hbname, hbai);
			vb.setLayoutX(50);
			vb.setLayoutY(150);
////////////////////////////////////////////////////// 
			VBox vbchose = new VBox(10);
			Label labchose = new Label("whose want Start:");
			ComboBox cb = new ComboBox();
			cb.getItems().addAll("X", "O");
			vbchose.setLayoutX(50);
			vbchose.setLayoutY(250);
			vbchose.getChildren().addAll(labchose, cb);
/////////////////////////////////
			Label lab = new Label("how many round you want?");
			TextField roundnum = new TextField();
			VBox vbround = new VBox(10);
			vbround.setLayoutX(150);
			vbround.setLayoutY(250);
			vbround.getChildren().addAll(lab, roundnum);
///////////////////////////////////////////////////
			Button startbutton = new Button("Start");
			startbutton.setLayoutX(300);
			startbutton.setLayoutY(350);
///////////////////////////////////////back
			Button back = new Button("Back");
			back.setLayoutX(20);
			back.setLayoutY(400);
//////////////////////////////////////////
			Label Labb = new Label("");
			Labb.setLayoutX(70);
			Labb.setLayoutY(400);

////////////////////////////////////////////////	
//////////////////////////////////////////////////////////////////////////////////////
			Scene sn1 = new Scene(start, 700, 500);
			Stage stg = new Stage();
			stg.setScene(sn1);
			stg.show();
			primaryStage.close();

			back.setOnAction(w -> {
				stg.close();
				primaryStage.show();
				Labb.setText("");
			});
			start.getChildren().addAll(vb, vbchose, startbutton, vbround, back, Labb);
////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////Start ai randome
//////////////////////////////////////////////////////////////////////////////////////
			startbutton.setOnAction(r -> {
				if (tf1.getText().equals("")) {
					Labb.setText("Please write your name");
				} else if (cb.getSelectionModel().isEmpty()) {
					Labb.setText("Please enter whos start");
				} else if (roundnum.getText().equals("")) {
					Labb.setText("Please enter how much round you want");

				} else {
					Pane panplay1 = new Pane();
					GridPane panplay2 = new GridPane();
					panplay2.setAlignment(Pos.CENTER);
					panplay2.setHgap(5);
					panplay2.setVgap(5);
					panplay2.setLayoutX(220);
					panplay2.setLayoutY(110);

					Button reset = new Button("Reset");
					Button changechose = new Button("backToChange");
					reset.setLayoutX(320);
					reset.setLayoutY(450);

//changechose.setLayoutX(390);
//changechose.setLayoutY(450);
//changechose.setOnAction(w->{
//
//});
////////////////////////////////////////////////////print whose when
					Label labwin = new Label();
					labwin.setLayoutX(260);
					labwin.setLayoutY(80);
////////////////////////////////////////////////////text			  
					TextArea taplayer1 = new TextArea();
					taplayer1.setLayoutX(5);
					taplayer1.setLayoutY(110);
					taplayer1.setMaxWidth(100);
					taplayer1.setMinHeight(200);
					taplayer1.setStyle("-fx-background-color:transparent");
////////////////////////////////////////////////
					TextArea taplayer2 = new TextArea();
					taplayer2.setStyle("-fx-background-color:transparent");
					taplayer2.setLayoutX(590);
					taplayer2.setLayoutY(110);
					taplayer2.setMaxWidth(100);
					taplayer2.setMinHeight(200);
//////////////////////////////////////////////////player names
					Label labname11 = new Label(tf1.getText() + "\n");
					labname11.setLayoutX(30);
					labname11.setLayoutY(80);
					Label labname22 = new Label("Ai");
					labname22.setLayoutX(600);
					labname22.setLayoutY(80);
//////////////////////////////////////////////////////////////////////////////add button for game
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							Button button = new Button();
							button.setMinSize(100, 100);
							button.setStyle("-fx-font-size: 24");
							buttons[i][j] = button;
							panplay2.add(button, i, j);// add to grid pane
							int h = i;
							int u = j;

							//////////////////////////////////////////////////////////// button action

							if ((r2Ai.isSelected())) {
								Button btn = new Button("start Ai");
								btn.setLayoutX(10);
								btn.setLayoutY(20);
								panplay1.getChildren().add(btn);
								btn.setOnAction(n -> {
									Random rand1 = new Random();
									int p;
									int v;
									do {
										p = rand1.nextInt(3);
										v = rand1.nextInt(3);
									} while (!buttons[p][v].getText().equals(""));
									buttons[p][v].setText("" + cb.getValue());
								});

								button.setOnAction(o -> {
									if (cb.getValue() == "X") {
										currentPlayer = "O";
									} else {
										currentPlayer = "X";
									}
									if (buttons[h][u].getText().equals("")) {
										buttons[h][u].setText(String.valueOf(currentPlayer));

										if (buttons[h][0].getText().equals(String.valueOf(currentPlayer))
												&& buttons[h][1].getText().equals(String.valueOf(currentPlayer))
												&& buttons[h][2].getText().equals(String.valueOf(currentPlayer))) {

											if (buttons[h][0].getText() == cb.getValue()) {
												labwin.setText("Ai" + " wins!");
												Score2++;
												taplayer2.setText("Score:" + Score2);

											} else {
												labwin.setText(tf1.getText() + " wins!");
												Score1++;
												taplayer1.setText("Score:" + Score1);
											}

											buttons[h][0].setTextFill(Color.GREEN);
											buttons[h][1].setTextFill(Color.GREEN);
											buttons[h][2].setTextFill(Color.GREEN);
											for (int k = 0; k < 3; k++) {
												for (int y = 0; y < 3; y++) {
													if (buttons[k][y].getText().equals("")) {
														buttons[k][y].setDisable(true);
													}

												}
											}

										} else if (buttons[0][u].getText().equals(String.valueOf(currentPlayer))
												&& buttons[1][u].getText().equals(String.valueOf(currentPlayer))
												&& buttons[2][u].getText().equals(String.valueOf(currentPlayer))) {
											// System.out.println("Player " + currentPlayer + " wins!");
											if (buttons[h][0].getText() == cb.getValue()) {
												labwin.setText("Ai" + " wins!");
												Score2++;
												taplayer2.setText("Score:" + Score2);

											} else {
												labwin.setText(tf1.getText() + " wins!");
												Score1++;
												taplayer1.setText("Score:" + Score1);
											}

											buttons[0][u].setTextFill(Color.GREEN);
											buttons[1][u].setTextFill(Color.GREEN);
											buttons[2][u].setTextFill(Color.GREEN);
											for (int k = 0; k < 3; k++) {
												for (int y = 0; y < 3; y++) {
													if (buttons[k][y].getText().equals("")) {
														buttons[k][y].setDisable(true);
													}

												}
											}
										}

										else if (h == u && buttons[0][0].getText().equals(String.valueOf(currentPlayer))
												&& buttons[1][1].getText().equals(String.valueOf(currentPlayer))
												&& buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
											// System.out.println("Player " + currentPlayer + " wins!");
											if (buttons[h][0].getText() == cb.getValue()) {
												labwin.setText("Ai" + " wins!");
												Score2++;
												taplayer2.setText("Score:" + Score2);

											} else {
												labwin.setText(tf1.getText() + " wins!");
												Score1++;
												taplayer1.setText("Score:" + Score1);
											}
//
											buttons[0][0].setTextFill(Color.GREEN);
											buttons[1][1].setTextFill(Color.GREEN);
											buttons[2][2].setTextFill(Color.GREEN);
											for (int k = 0; k < 3; k++) {
												for (int y = 0; y < 3; y++) {
													if (buttons[k][y].getText().equals("")) {
														buttons[k][y].setDisable(true);
													}
												}
											}
										}

										else if (h + u == 2
												&& buttons[0][2].getText().equals(String.valueOf(currentPlayer))
												&& buttons[1][1].getText().equals(String.valueOf(currentPlayer))
												&& buttons[2][0].getText().equals(String.valueOf(currentPlayer))) {
//	 System.out.println("Player " + currentPlayer + " wins!");
											if (buttons[h][0].getText() == cb.getValue()) {
												labwin.setText("Ai" + " wins!");
												Score2++;
												taplayer2.setText("Score:" + Score2);

											} else {
												labwin.setText(tf1.getText() + " wins!");
												Score1++;
												taplayer1.setText("Score:" + Score1);
											}

//
											buttons[0][2].setTextFill(Color.GREEN);
											buttons[1][1].setTextFill(Color.GREEN);
											buttons[2][0].setTextFill(Color.GREEN);
											for (int k = 0; k < 3; k++) {
												for (int y = 0; y < 3; y++) {
													if (buttons[k][y].getText().equals("")) {
														buttons[k][y].setDisable(true);
													}
												}
											}

										} else if (isBoardFull()) {
											showDraw();
										}
										/////////////////////////////////////////////////////////////////////////////////// randome
										/////////////////////////////////////////////////////////////////////////////////// turn
										else {

											if (currentPlayer.equals("X")) {
												Random rand2 = new Random();
												int p1;
												int v1;
												do {
													p1 = rand2.nextInt(3);
													v1 = rand2.nextInt(3);
												} while (!buttons[p1][v1].getText().equals(""));
												buttons[p1][v1].setText("O");
												if (buttons[p1][v1].getText().equals("")) {
													buttons[p1][v1].setText(String.valueOf(currentPlayer));

													if (buttons[p1][0].getText().equals(String.valueOf(currentPlayer))
															&& buttons[p1][1].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[p1][2].getText()
																	.equals(String.valueOf(currentPlayer))) {

														if (buttons[p1][v1].getText() == cb.getValue()) {
															labwin.setText("Ai" + " wins!");
															Score2++;
															taplayer2.setText("Score:" + Score2);

														} else {
															labwin.setText(tf1.getText() + " wins!");
															Score1++;
															taplayer1.setText("Score:" + Score1);
														}

														//
														buttons[p1][0].setTextFill(Color.GREEN);
														buttons[p1][1].setTextFill(Color.GREEN);
														buttons[p1][2].setTextFill(Color.GREEN);
														for (int k = 0; k < 3; k++) {
															for (int y = 0; y < 3; y++) {
																if (buttons[k][y].getText().equals("")) {
																	buttons[k][y].setDisable(true);
																}

															}
														}

													} else if (buttons[0][v1].getText()
															.equals(String.valueOf(currentPlayer))
															&& buttons[1][v1].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[2][v1].getText()
																	.equals(String.valueOf(currentPlayer))) {
														// System.out.println("Player " + currentPlayer + " wins!");
														if (buttons[p1][v1].getText() == cb.getValue()) {
															labwin.setText("Ai" + " wins!");
															Score2++;
															taplayer2.setText("Score:" + Score2);

														} else {
															labwin.setText(tf1.getText() + " wins!");
															Score1++;
															taplayer1.setText("Score:" + Score1);
														}

														buttons[0][v1].setTextFill(Color.GREEN);
														buttons[1][v1].setTextFill(Color.GREEN);
														buttons[2][v1].setTextFill(Color.GREEN);
														for (int k = 0; k < 3; k++) {
															for (int y = 0; y < 3; y++) {
																if (buttons[k][y].getText().equals("")) {
																	buttons[k][y].setDisable(true);
																}

															}
														}
													}

													else if (h == u
															&& buttons[0][0].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[1][1].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[2][2].getText()
																	.equals(String.valueOf(currentPlayer))) {
														// System.out.println("Player " + currentPlayer + " wins!");
														if (buttons[p1][v1].getText() == cb.getValue()) {
															labwin.setText("Ai" + " wins!");
															Score2++;
															taplayer2.setText("Score:" + Score2);

														} else {
															labwin.setText(tf1.getText() + " wins!");
															Score1++;
															taplayer1.setText("Score:" + Score1);
														}

														//
														buttons[0][0].setTextFill(Color.GREEN);
														buttons[1][1].setTextFill(Color.GREEN);
														buttons[2][2].setTextFill(Color.GREEN);
														for (int k = 0; k < 3; k++) {
															for (int y = 0; y < 3; y++) {
																if (buttons[k][y].getText().equals("")) {
																	buttons[k][y].setDisable(true);
																}
															}
														}
													}

													else if (h + u == 2
															&& buttons[0][2].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[1][1].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[2][0].getText()
																	.equals(String.valueOf(currentPlayer))) {
//		 System.out.println("Player " + currentPlayer + " wins!");
														if (buttons[p1][v1].getText() == cb.getValue()) {
															labwin.setText("Ai" + " wins!");
															Score2++;
															taplayer2.setText("Score:" + Score2);

														} else {
															labwin.setText(tf1.getText() + " wins!");
															Score1++;
															taplayer1.setText("Score:" + Score1);
														}

														buttons[0][2].setTextFill(Color.GREEN);
														buttons[1][1].setTextFill(Color.GREEN);
														buttons[2][0].setTextFill(Color.GREEN);
														for (int k = 0; k < 3; k++) {
															for (int y = 0; y < 3; y++) {
																if (buttons[k][y].getText().equals("")) {
																	buttons[k][y].setDisable(true);
																}
															}
														}

													} else if (isBoardFull()) {
														showDraw();
													}
													/////////////////////////////////////////////////////////////////////////////////// randome
													/////////////////////////////////////////////////////////////////////////////////// turn
												}
											}

											else {
												Random rand0 = new Random();
												int p2;
												int v2;
												do {
													p2 = rand0.nextInt(3);
													v2 = rand0.nextInt(3);
												} while (!buttons[p2][v2].getText().equals(""));
												buttons[p2][v2].setText("X");
												if (buttons[p2][v2].getText().equals("")) {
													buttons[p2][v2].setText(String.valueOf(currentPlayer));

													if (buttons[p2][0].getText().equals(String.valueOf(currentPlayer))
															&& buttons[p2][1].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[p2][2].getText()
																	.equals(String.valueOf(currentPlayer))) {

														if (buttons[p2][v2].getText() == cb.getValue()) {
															labwin.setText("Ai" + " wins!");
															Score2++;
															taplayer2.setText("Score:" + Score2);

														} else {
															labwin.setText(tf1.getText() + " wins!");
															Score1++;
															taplayer1.setText("Score:" + Score1);
														}

														buttons[p2][0].setTextFill(Color.GREEN);
														buttons[p2][1].setTextFill(Color.GREEN);
														buttons[p2][2].setTextFill(Color.GREEN);
														for (int k = 0; k < 3; k++) {
															for (int y = 0; y < 3; y++) {
																if (buttons[k][y].getText().equals("")) {
																	buttons[k][y].setDisable(true);
																}

															}
														}

													} else if (buttons[0][v2].getText()
															.equals(String.valueOf(currentPlayer))
															&& buttons[1][v2].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[2][v2].getText()
																	.equals(String.valueOf(currentPlayer))) {
														// System.out.println("Player " + currentPlayer + " wins!");
														if (buttons[p2][v2].getText() == cb.getValue()) {
															labwin.setText("Ai" + " wins!");
															Score2++;
															taplayer2.setText("Score:" + Score2);

														} else {
															labwin.setText(tf1.getText() + " wins!");
															Score1++;
															taplayer1.setText("Score:" + Score1);
														}

														buttons[0][v2].setTextFill(Color.GREEN);
														buttons[1][v2].setTextFill(Color.GREEN);
														buttons[2][v2].setTextFill(Color.GREEN);
														for (int k = 0; k < 3; k++) {
															for (int y = 0; y < 3; y++) {
																if (buttons[k][y].getText().equals("")) {
																	buttons[k][y].setDisable(true);
																}

															}
														}
													}

													else if (h == u
															&& buttons[0][0].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[1][1].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[2][2].getText()
																	.equals(String.valueOf(currentPlayer))) {
														// System.out.println("Player " + currentPlayer + " wins!");
														if (buttons[p2][v2].getText() == cb.getValue()) {
															labwin.setText("Ai" + " wins!");
															Score2++;
															taplayer2.setText("Score:" + Score2);

														} else {
															labwin.setText(tf1.getText() + " wins!");
															Score1++;
															taplayer1.setText("Score:" + Score1);
														}

														//
														buttons[0][0].setTextFill(Color.GREEN);
														buttons[1][1].setTextFill(Color.GREEN);
														buttons[2][2].setTextFill(Color.GREEN);
														for (int k = 0; k < 3; k++) {
															for (int y = 0; y < 3; y++) {
																if (buttons[k][y].getText().equals("")) {
																	buttons[k][y].setDisable(true);
																}
															}
														}
													}

													else if (h + u == 2
															&& buttons[0][2].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[1][1].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[2][0].getText()
																	.equals(String.valueOf(currentPlayer))) {
//		 System.out.println("Player " + currentPlayer + " wins!");
														if (buttons[p2][v2].getText() == cb.getValue()) {
															labwin.setText("Ai" + " wins!");
															Score2++;
															taplayer2.setText("Score:" + Score2);

														} else {
															labwin.setText(tf1.getText() + " wins!");
															Score1++;
															taplayer1.setText("Score:" + Score1);
														}

														buttons[0][2].setTextFill(Color.GREEN);
														buttons[1][1].setTextFill(Color.GREEN);
														buttons[2][0].setTextFill(Color.GREEN);
														for (int k = 0; k < 3; k++) {
															for (int y = 0; y < 3; y++) {
																if (buttons[k][y].getText().equals("")) {
																	buttons[k][y].setDisable(true);
																}
															}
														}

													} else if (isBoardFull()) {
														showDraw();
													}
													/////////////////////////////////////////////////////////////////////////////////// randome
													/////////////////////////////////////////////////////////////////////////////////// turn
												}
											}
										}
									}

								});
							} else {
								button.setOnAction(o -> {
									if (buttons[h][u].getText().equals("")) {
										buttons[h][u].setText(String.valueOf(currentPlayer));

										if (buttons[h][0].getText().equals(String.valueOf(currentPlayer))
												&& buttons[h][1].getText().equals(String.valueOf(currentPlayer))
												&& buttons[h][2].getText().equals(String.valueOf(currentPlayer))) {

											if (r1name.isSelected()) {
												if (currentPlayer == cb.getValue()) {
													labwin.setText("Ai" + " wins!");
													Score1++;
													taplayer2.setText("Score:" + Score1);
												} else {
													labwin.setText(tf1.getText() + " wins!");
													Score2++;
													taplayer1.setText("Score:" + Score2);
												}
											} else if (r2Ai.isSelected()) {
												if (currentPlayer == cb.getValue()) {
													labwin.setText("Ai" + " wins!");
													Score2++;
													taplayer2.setText("Score:" + Score2);

												} else {
													labwin.setText(tf1.getText() + " wins!");
													Score1++;
													taplayer1.setText("Score:" + Score1);
												}
											}

//
											buttons[h][0].setTextFill(Color.GREEN);
											buttons[h][1].setTextFill(Color.GREEN);
											buttons[h][2].setTextFill(Color.GREEN);
											for (int k = 0; k < 3; k++) {
												for (int y = 0; y < 3; y++) {
													if (buttons[k][y].getText().equals("")) {
														buttons[k][y].setDisable(true);
													}

												}
											}

										} else if (buttons[0][u].getText().equals(String.valueOf(currentPlayer))
												&& buttons[1][u].getText().equals(String.valueOf(currentPlayer))
												&& buttons[2][u].getText().equals(String.valueOf(currentPlayer))) {
//System.out.println("Player " + currentPlayer + " wins!");
											if (r1name.isSelected()) {
												if (currentPlayer == cb.getValue()) {
													labwin.setText("Ai" + " wins!");
													Score1++;
													taplayer2.setText("Score:" + Score1);
												} else {
													labwin.setText(tf1.getText() + " wins!");
													Score2++;
													taplayer1.setText("Score:" + Score2);
												}
											} else if (r2Ai.isSelected()) {
												if (currentPlayer == cb.getValue()) {
													labwin.setText("Ai" + " wins!");
													Score2++;
													taplayer2.setText("Score:" + Score2);

												} else {
													labwin.setText(tf1.getText() + " wins!");
													Score1++;
													taplayer1.setText("Score:" + Score1);
												}
											}

//

											buttons[0][u].setTextFill(Color.GREEN);
											buttons[1][u].setTextFill(Color.GREEN);
											buttons[2][u].setTextFill(Color.GREEN);
											for (int k = 0; k < 3; k++) {
												for (int y = 0; y < 3; y++) {
													if (buttons[k][y].getText().equals("")) {
														buttons[k][y].setDisable(true);
													}

												}
											}
										}

										else if (h == u && buttons[0][0].getText().equals(String.valueOf(currentPlayer))
												&& buttons[1][1].getText().equals(String.valueOf(currentPlayer))
												&& buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
//System.out.println("Player " + currentPlayer + " wins!");
											if (r1name.isSelected()) {
												if (currentPlayer == cb.getValue()) {
													labwin.setText("Ai" + " wins!");
													Score1++;
													taplayer2.setText("Score:" + Score1);
												} else {
													labwin.setText(tf1.getText() + " wins!");
													Score2++;
													taplayer1.setText("Score:" + Score2);
												}
											} else if (r2Ai.isSelected()) {
												if (currentPlayer == cb.getValue()) {
													labwin.setText("Ai" + " wins!");
													Score2++;
													taplayer2.setText("Score:" + Score2);

												} else {
													labwin.setText(tf1.getText() + " wins!");
													Score1++;
													taplayer1.setText("Score:" + Score1);
												}
											}

//
											buttons[0][0].setTextFill(Color.GREEN);
											buttons[1][1].setTextFill(Color.GREEN);
											buttons[2][2].setTextFill(Color.GREEN);
											for (int k = 0; k < 3; k++) {
												for (int y = 0; y < 3; y++) {
													if (buttons[k][y].getText().equals("")) {
														buttons[k][y].setDisable(true);
													}
												}
											}
										}

										else if (h + u == 2
												&& buttons[0][2].getText().equals(String.valueOf(currentPlayer))
												&& buttons[1][1].getText().equals(String.valueOf(currentPlayer))
												&& buttons[2][0].getText().equals(String.valueOf(currentPlayer))) {
//	 System.out.println("Player " + currentPlayer + " wins!");
											if (r1name.isSelected()) {
												if (currentPlayer == cb.getValue()) {
													labwin.setText("Ai" + " wins!");
													Score1++;
													taplayer2.setText("Score:" + Score1);
												} else {
													labwin.setText(tf1.getText() + " wins!");
													Score2++;
													taplayer1.setText("Score:" + Score2);
												}
											} else if (r2Ai.isSelected()) {
												if (currentPlayer == cb.getValue()) {
													labwin.setText("Ai" + " wins!");
													Score2++;
													taplayer2.setText("Score:" + Score2);

												} else {
													labwin.setText(tf1.getText() + " wins!");
													Score1++;
													taplayer1.setText("Score:" + Score1);
												}
											}

//
											buttons[0][2].setTextFill(Color.GREEN);
											buttons[1][1].setTextFill(Color.GREEN);
											buttons[2][0].setTextFill(Color.GREEN);
											for (int k = 0; k < 3; k++) {
												for (int y = 0; y < 3; y++) {
													if (buttons[k][y].getText().equals("")) {
														buttons[k][y].setDisable(true);
													}
												}
											}

										} else if (isBoardFull()) {
											showDraw();
										}
										/////////////////////////////////////////////////////////////////////////////////// randome
										/////////////////////////////////////////////////////////////////////////////////// turn
										else {

											if (currentPlayer.equals("X")) {
												Random rand2 = new Random();
												int p1;
												int v1;
												do {
													p1 = rand2.nextInt(3);
													v1 = rand2.nextInt(3);
												} while (!buttons[p1][v1].getText().equals(""));
												buttons[p1][v1].setText("O");
												if (buttons[p1][v1].getText().equals("")) {
													buttons[p1][v1].setText(String.valueOf(currentPlayer));
													if (buttons[p1][0].getText().equals(String.valueOf(currentPlayer))
															&& buttons[p1][1].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[p1][2].getText()
																	.equals(String.valueOf(currentPlayer))) {

														labwin.setText("Ai" + " wins!");
														Score2++;
														taplayer2.setText("Score:" + Score1);

														//
														buttons[p1][0].setTextFill(Color.GREEN);
														buttons[p1][1].setTextFill(Color.GREEN);
														buttons[p1][2].setTextFill(Color.GREEN);
														for (int k = 0; k < 3; k++) {
															for (int y = 0; y < 3; y++) {
																if (buttons[k][y].getText().equals("")) {
																	buttons[k][y].setDisable(true);
																}

															}
														}

													} else if (buttons[0][v1].getText()
															.equals(String.valueOf(currentPlayer))
															&& buttons[1][v1].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[2][v1].getText()
																	.equals(String.valueOf(currentPlayer))) {
														// System.out.println("Player " + currentPlayer + " wins!");
														labwin.setText("Ai" + " wins!");
														Score2++;
														taplayer2.setText("Score:" + Score1);

														buttons[0][v1].setTextFill(Color.GREEN);
														buttons[1][v1].setTextFill(Color.GREEN);
														buttons[2][v1].setTextFill(Color.GREEN);
														for (int k = 0; k < 3; k++) {
															for (int y = 0; y < 3; y++) {
																if (buttons[k][y].getText().equals("")) {
																	buttons[k][y].setDisable(true);
																}

															}
														}
													}

													else if (h == u
															&& buttons[0][0].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[1][1].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[2][2].getText()
																	.equals(String.valueOf(currentPlayer))) {
														// System.out.println("Player " + currentPlayer + " wins!");
														labwin.setText("Ai" + " wins!");
														Score2++;
														taplayer2.setText("Score:" + Score1);

														//
														buttons[0][0].setTextFill(Color.GREEN);
														buttons[1][1].setTextFill(Color.GREEN);
														buttons[2][2].setTextFill(Color.GREEN);
														for (int k = 0; k < 3; k++) {
															for (int y = 0; y < 3; y++) {
																if (buttons[k][y].getText().equals("")) {
																	buttons[k][y].setDisable(true);
																}
															}
														}
													}

													else if (h + u == 2
															&& buttons[0][2].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[1][1].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[2][0].getText()
																	.equals(String.valueOf(currentPlayer))) {
//		 System.out.println("Player " + currentPlayer + " wins!");
														labwin.setText("Ai" + " wins!");
														Score2++;
														taplayer2.setText("Score:" + Score1);

														buttons[0][2].setTextFill(Color.GREEN);
														buttons[1][1].setTextFill(Color.GREEN);
														buttons[2][0].setTextFill(Color.GREEN);
														for (int k = 0; k < 3; k++) {
															for (int y = 0; y < 3; y++) {
																if (buttons[k][y].getText().equals("")) {
																	buttons[k][y].setDisable(true);
																}
															}
														}

													} else if (isBoardFull()) {
														showDraw();
													}
													/////////////////////////////////////////////////////////////////////////////////// randome
													/////////////////////////////////////////////////////////////////////////////////// turn
												}
											}

											else {
												Random rand0 = new Random();
												int p2;
												int v2;
												do {
													p2 = rand0.nextInt(3);
													v2 = rand0.nextInt(3);
												} while (!buttons[p2][v2].getText().equals(""));
												buttons[p2][v2].setText("X");
												if (buttons[p2][v2].getText().equals("")) {
													buttons[p2][v2].setText(String.valueOf(currentPlayer));

													if (buttons[p2][0].getText().equals(String.valueOf(currentPlayer))
															&& buttons[p2][1].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[p2][2].getText()
																	.equals(String.valueOf(currentPlayer))) {

														labwin.setText("Ai" + " wins!");
														Score2++;
														taplayer2.setText("Score:" + Score1);

														//
														buttons[p2][0].setTextFill(Color.GREEN);
														buttons[p2][1].setTextFill(Color.GREEN);
														buttons[p2][2].setTextFill(Color.GREEN);
														for (int k = 0; k < 3; k++) {
															for (int y = 0; y < 3; y++) {
																if (buttons[k][y].getText().equals("")) {
																	buttons[k][y].setDisable(true);
																}

															}
														}

													} else if (buttons[0][v2].getText()
															.equals(String.valueOf(currentPlayer))
															&& buttons[1][v2].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[2][v2].getText()
																	.equals(String.valueOf(currentPlayer))) {
														// System.out.println("Player " + currentPlayer + " wins!");
														labwin.setText("Ai" + " wins!");
														Score2++;
														taplayer2.setText("Score:" + Score1);

														buttons[0][v2].setTextFill(Color.GREEN);
														buttons[1][v2].setTextFill(Color.GREEN);
														buttons[2][v2].setTextFill(Color.GREEN);
														for (int k = 0; k < 3; k++) {
															for (int y = 0; y < 3; y++) {
																if (buttons[k][y].getText().equals("")) {
																	buttons[k][y].setDisable(true);
																}

															}
														}
													}

													else if (h == u
															&& buttons[0][0].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[1][1].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[2][2].getText()
																	.equals(String.valueOf(currentPlayer))) {
														// System.out.println("Player " + currentPlayer + " wins!");
														labwin.setText("Ai" + " wins!");
														Score2++;
														taplayer2.setText("Score:" + Score1);

														//
														buttons[0][0].setTextFill(Color.GREEN);
														buttons[1][1].setTextFill(Color.GREEN);
														buttons[2][2].setTextFill(Color.GREEN);
														for (int k = 0; k < 3; k++) {
															for (int y = 0; y < 3; y++) {
																if (buttons[k][y].getText().equals("")) {
																	buttons[k][y].setDisable(true);
																}
															}
														}
													}

													else if (h + u == 2
															&& buttons[0][2].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[1][1].getText()
																	.equals(String.valueOf(currentPlayer))
															&& buttons[2][0].getText()
																	.equals(String.valueOf(currentPlayer))) {
//		 System.out.println("Player " + currentPlayer + " wins!");
														labwin.setText("Ai" + " wins!");
														Score2++;
														taplayer2.setText("Score:" + Score1);

														buttons[0][2].setTextFill(Color.GREEN);
														buttons[1][1].setTextFill(Color.GREEN);
														buttons[2][0].setTextFill(Color.GREEN);
														for (int k = 0; k < 3; k++) {
															for (int y = 0; y < 3; y++) {
																if (buttons[k][y].getText().equals("")) {
																	buttons[k][y].setDisable(true);
																}
															}
														}

													} else if (isBoardFull()) {
														showDraw();
													}
													/////////////////////////////////////////////////////////////////////////////////// randome
													/////////////////////////////////////////////////////////////////////////////////// turn
												}
											}
										}
									}

								});
							}

						}
					}
					Label labend = new Label("");
					reset.setOnAction(p -> {
						int X=(Integer.parseInt(roundnum.getText())/2);
//						
						Math.round(X);
						System.out.println(X);
						d++;
						if (d == Integer.parseInt(roundnum.getText())
								|| (Score1 + Score2) == Integer.parseInt(roundnum.getText())) {
							    
							labend.setText("Game End");
							reset.setDisable(false);
							Score1=0;
							Score2=0;
							labend.setFont(Font.font("Arial", 30));
							labend.setTextFill(Color.BLUE);
							labend.setFont(font1);
							labend.setLayoutX(300);
							labend.setLayoutY(450);
							resetGame();
						
							
						
							for (int k = 0; k < 3; k++) {
								for (int y = 0; y < 3; y++) {
									buttons[k][y].setDisable(true);
									labwin.setText("");
									currentPlayer = "" + cb.getValue();
								}

							}
						}
//						
						else if(Score1==X) {
							Score1=0;
							Score2=0;
							labend.setText(tf1.getText()+" is winner");
							
							labend.setFont(Font.font("Arial", 30));
							labend.setTextFill(Color.BLUE);
							labend.setFont(font1);
							labend.setLayoutX(300);
							labend.setLayoutY(20);
							//resetGame();
						}else if(Score2==X) {
                              labend.setText("Ai"+" is winner");
                              Score1=0;
  							Score2=0;
							labend.setFont(Font.font("Arial", 30));
							labend.setTextFill(Color.BLUE);
							labend.setFont(font1);
							labend.setLayoutX(300);
							labend.setLayoutY(20);
							//resetGame();
						}
						else {
							resetGame();
							for (int k = 0; k < 3; k++) {
								for (int y = 0; y < 3; y++) {
									if (buttons[k][y].getText().equals("")) {
										buttons[k][y].setDisable(false);
										buttons[k][y].setTextFill(Color.BLACK);
										labwin.setText("");
										currentPlayer = "" + cb.getValue();
									}
								}
							}
						}
					});

					reset.setLayoutX(500);
					reset.setLayoutY(450);

////////////////////////////////////////////////////back button
					Button back2 = new Button("BackToChange");
					back2.setLayoutX(20);
					back2.setLayoutY(450);
/////////////////////////////////////////////////////////text field

//////////////////////////////////////////////////////// vvox to but hbox
					VBox vb2 = new VBox(10);
//vb.getChildren().addAll(hb1, hb2, hb3);
					vb2.setAlignment(Pos.CENTER);
					vb2.setLayoutX(220);
					vb2.setLayoutY(110);
//////////////////////////////////////////////////text area
					;

//taplayer2.setStyle("-fx-background-color: #fff; -fx-border-color: #fff; -fx-border-width: 0; -fx-border-image-width: 0; -fx-background-image: null; -fx-region-background: null;-fx-border-insets: 0; -fx-background-size:0; -fx-border-image-insets:0;");
					Label labstartxy = new Label(cb.getValue() + "player is start");
					labstartxy.setLayoutX(30);
					labstartxy.setLayoutY(50);

					panplay1.getChildren().addAll(labstartxy, taplayer1, labwin, panplay2, labname11, labname22,
							taplayer2, back2, reset, labend);
///////////////////////////////////////////////////////////////////////////		
					currentPlayer = "" + cb.getValue();
/////////////////////////////////////////////////////////////////////////
					Scene sn2 = new Scene(panplay1, 700, 500);
					Stage stg1 = new Stage();
					stg1.setScene(sn2);
					stg1.show();
					primaryStage.close();
					stg.close();
					back2.setOnAction(w -> {
						stg1.close();
						stg.show();
					});
				}

			});

		});

		// *******************************************************************************************
/////////////////////////////////////////////////////////////////////////////////////////////////////MINMAX
/////////////////////////////////////////////////////////////////////////////////////////////////////		
/////////////////////////////////////////////////////////////////////////////////////////////////////		
		ComputerMinMax.setOnAction(e -> {
//			
		});

//////////////////////////////////////////////////////////////////////////////////////////////	
		Scene sn = new Scene(panmain, 700, 550);
		primaryStage.setScene(sn);
		primaryStage.show();
	}

	 public static boolean isWinner(char[][] board, char player) {
	        // Check rows, columns, and diagonals for a win
	        for (int i = 0; i < 3; i++) {
	            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
	                return true;
	            }
	            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
	                return true;
	            }
	        }
	        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
	            return true;
	        }
	        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
	            return true;
	        }
	        return false;
	    }

	 public static Integer evaluate(char[][] board) {
	        // Evaluate the current state of the board
	        if (isWinner(board, 'X')) {
	            return 1;
	        } else if (isWinner(board, 'O')) {
	            return -1;
	        } else if (isBoardFull(board)) {
	            return 0;
	        } else {
	            return null;
	        }
	    }
	 public static boolean isBoardFull(char[][] board) {
	        // Check if the board is full
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (board[i][j] == '\0') {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    public static int minimax(char[][] board, int depth, boolean isMaximizing) {
	        Integer score = evaluate(board);

	        if (score != null) {
	            return score;
	        }

	        if (isMaximizing) {
	            int maxEval = Integer.MIN_VALUE;
	            for (int i = 0; i < 3; i++) {
	                for (int j = 0; j < 3; j++) {
	                    if (board[i][j] == '\0') {
	                        board[i][j] = 'X';
	                        int eval = minimax(board, depth + 1, false);
	                        board[i][j] = '\0';
	                        maxEval = Math.max(maxEval, eval);
	                    }
	                }
	            }
	            return maxEval;
	        } else {
	            int minEval = Integer.MAX_VALUE;
	            for (int i = 0; i < 3; i++) {
	                for (int j = 0; j < 3; j++) {
	                    if (board[i][j] == '\0') {
	                        board[i][j] = 'O';
	                        int eval = minimax(board, depth + 1, true);
	                        board[i][j] = '\0';
	                        minEval = Math.min(minEval, eval);
	                    }
	                }
	            }
	            return minEval;
	        }
	    }

	    public static int[] findBestMove(char[][] board) {
	        int bestVal = Integer.MIN_VALUE;
	        int[] bestMove = {-1, -1};

	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (board[i][j] == '\0') {
	                    board[i][j] = 'X';
	                    int moveVal = minimax(board, 0, false);
	                    board[i][j] = '\0';

	                    if (moveVal > bestVal) {
	                        bestMove[0] = i;
	                        bestMove[1] = j;
	                        bestVal = moveVal;
	                    }
	                }
	            }
	        }

	        return bestMove;
	    }

	private boolean isBoardFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (buttons[i][j].getText().equals("")) {
					return false;
				}
			}
		}
		return true;
	}

	private void showWinner() {
		System.out.println("Player " + currentPlayer + " wins!");
		resetGame();
	}

	private void showDraw() {
//	        System.out.println("It's a draw!");
		resetGame();
	}

	private void resetGame() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j].setText("");
			}
		}
		currentPlayer = "X";
	}

	public static void main(String[] args) {
		launch(args);
	}
}
