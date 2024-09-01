import java.util.Scanner;

public class tictactoe 
{

	public static char[][]board=new char [3][3];
	public static char whowon;
	//System.out.println("   |   |   \n-----------\n   |   |   \n-----------\n   |   |   ");
	public static void main(String[] args) 
	{
		head();		
		Scanner in = new Scanner(System.in);
		System.out.println("Would you like to read the instructions\n"
				+ "	(Yes/No)");
		String instuct = in.nextLine();
		if(instuct.charAt(0)=='y'||instuct.charAt(0)=='Y'||instuct.charAt(0)=='y')
		{
			instruction();
		}
		boolean againall;
		do {
			System.out.println("One or Two Players");
			String gamemode = in.nextLine();
			if (gamemode.charAt(0) == '2' || gamemode.charAt(0) == 'T' || gamemode.charAt(0) == 't') 
			{
				gameplayall(1, 2);
			} 
			else 
			{
				System.out.println("COM Easy or COM Normal or COM Hard\n" + "	(Easy/Normal/Hard)");
				String difficulty = in.nextLine();
				if (difficulty.charAt(0) == 'H' || difficulty.charAt(0) == 'h' || difficulty.charAt(0) == '3')
				{
					gameplayall(1, 5);
				} else if (difficulty.charAt(0) == 'E' || difficulty.charAt(0) == 'e' || difficulty.charAt(0) == '1')
					gameplayall(1, 3);
				else if (difficulty.charAt(0) == 'i') 
				{
					System.out.println("i mode enabled. You play second now.\n");
					gameplayall(6, 2);
				} else if (difficulty.charAt(0) == 'N' || difficulty.charAt(0) == 'n' || difficulty.charAt(0) == '2') 
				{
					gameplayall(1, 4);
				}
				else 
				{
					System.out.println("Invaild input.\n" + "Defaulting to Norrmal...\n");
					gameplayall(1, 4);
				}
			}
			System.out.println("Done playing?\n" + "	(Yes/No)");
			String question = in.nextLine();
			againall = false;
			if (question.charAt(0) == (('N' | 'n')))
				againall = true;
		} while (againall);
		System.out.println("Thanks for playing.");		
		System.out.println("Fin");		
	}	
	public static void gameplayall(int first,int second) 
	{
		Scanner in= new Scanner(System.in);
		System.out.println("How many rounds would you like to play?");
		boolean againmode;
		do 
		{
			int roundcount = in.nextInt();
			if (roundcount < 1) 
			{
				System.out.println("Invaild Entry Try Again");
				gameplayall(first, second);
			}
			for (int roundcounter = 0; roundcounter < roundcount; roundcounter++) 
			{
				boardreset();
				System.out.println("Round " + (roundcounter + 1) + ":\nGame Start");
				for (int i = 0; i < 4; i++) 
				{
					if (!wincheck()) 
					{
						if (first == 1)
							printboard();
						playerinput(first);
					}
					if (!wincheck()) 
					{
						if (second == 2)
							printboard();
						playerinput(second);
					}
				}

				if (!wincheck()) 
				{
					if (first == 1)
						printboard();
					playerinput(first);
				}
				printboard();

				if (wincheck()) 
				{
					System.out.println(whowon + " wins");
				} 
				else 
				{
					printboard();
					System.out.println("A tie");
				}

			} 
			System.out.println("\nWould you like to add more rounds\n" + "	(Yes/No)");
			String morerounds = in.next();
			againmode = false;
			if (morerounds.charAt(0) == (('y' | 'Y')))
			{
				againmode = true;
				System.out.println("How many rounds would you like to add.");
			}
		} while (againmode);

	}
	public static void instruction() 
	{
		System.out.println("In TicTacToe your goal is to get three of your icon in a row.\n"
				+ "You play on the board by using the number with the corresponding with the spot on the board\n"
				+ "\n"
				+ " 1 | 2 | 3 \n"
				+ "---+---+---\n"
				+ " 4 | 5 | 6 \n"
				+ "---+---+---\n"
				+ " 7 | 8 | 9 \n"
				+ "\n"
				+ "The first player will be \"X\" \n"
				+ "The second player will be \"O\"\n"
				+ "If the opponent is the computer then the icon may vary.\n");
	}
	public static int spotCOM(boolean hard) 
	{
		for (int i = 0; i < 2; i++) 
		{
			char symbol='X';
			if(i==0)
				if(hard)
				{
					symbol='0';
				}
				else
					symbol='o';
			if ((board[0][0] == board[0][1]) && board[0][0] == symbol && board[0][2] == ' ') 
			{
				return 3;
			}
			if ((board[1][0] == board[1][1]) && board[1][0] == symbol && board[1][2] == ' ') 
			{
				return 6;
			}
			if ((board[2][0] == board[2][1]) && board[2][0] == symbol && board[2][2] == ' ') 
			{
				return 9;
			}
			if ((board[0][0] == board[1][0]) && board[0][0] == symbol && board[2][0] == ' ') 
			{
				return 7;
			}
			if ((board[0][1] == board[1][1]) && board[0][1] == symbol && board[2][1] == ' ') 
			{
				return 8;
			}
			if ((board[0][2] == board[1][2]) && board[0][2] == symbol && board[2][2] == ' ') 
			{
				return 9;
			}
			if ((board[0][0] == board[1][1]) && board[0][0] == symbol && board[2][2] == ' ') 
			{
				return 9;
			}
			if ((board[0][2] == board[1][1]) && board[0][2] == symbol && board[2][0] == ' ') 
			{
				return 7;
			}
			if ((board[0][0] == board[0][2]) && board[0][0] == symbol && board[0][1] == ' ') 
			{
				return 2;
			}
			if ((board[1][0] == board[1][2]) && board[1][0] == symbol && board[1][1] == ' ') 
			{
				return 5;
			}
			if ((board[2][0] == board[2][2]) && board[2][0] == symbol && board[2][1] == ' ') 
			{
				return 8;
			}
			if ((board[0][0] == board[2][0]) && board[0][0] == symbol && board[1][0] == ' ') 
			{
				return 4;
			}
			if ((board[0][1] == board[2][1]) && board[0][1] == symbol && board[1][1] == ' ') 
			{
				return 5;
			}
			if ((board[0][2] == board[2][2]) && board[0][2] == symbol && board[1][2] == ' ') 
			{
				return 6;
			}
			if ((board[0][0] == board[2][2]) && board[0][0] == symbol && board[1][1] == ' ') 
			{
				return 5;
			}
			if ((board[0][2] == board[2][0]) && board[0][2] == symbol && board[1][1] == ' ') 
			{
				return 5;
			}
			if ((board[0][1] == board[0][2]) && board[0][1] == symbol && board[0][0] == ' ') 
			{
				return 1;
			}
			if ((board[1][1] == board[1][2]) && board[1][1] == symbol && board[1][0] == ' ') 
			{
				return 4;
			}
			if ((board[2][1] == board[2][2]) && board[2][1] == symbol && board[2][0] == ' ') 
			{
				return 7;
			}
			if ((board[1][0] == board[2][0]) && board[1][0] == symbol && board[0][0] == ' ') 
			{
				return 1;
			}
			if ((board[1][1] == board[2][1]) && board[1][1] == symbol && board[0][1] == ' ') 
			{
				return 2;
			}
			if ((board[1][2] == board[2][2]) && board[1][2] == symbol && board[0][2] == ' ') 
			{
				return 3;
			}
			if ((board[1][1] == board[2][2]) && board[1][1] == symbol && board[0][0] == ' ') 
			{
				return 1;
			}
			if ((board[1][1] == board[2][0]) && board[1][1] == symbol && board[0][2] == ' ') 
			{
				return 3;
			} 
		}

		if (hard)
		{
			if(board[1][1]==' ')
				return 5;
			if(board[0][1]!='X'&&board[1][0]!='X'&&board[1][2]!='X'&&board[2][1]!='X')
			{
				return ((int)(Math.random()*4)+1)*2;
			}
			return (((int) (Math.random()*5))*2)+1;
		}
		return (int) (Math.random()*9)+1;
	}
	public static void head() 
	{
		System.out.println("\n"
				+ "    ())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())\n"
				+ "      ())     __________                          __________                        __________                       ())\n"
				+ "      ())    |__________|                        |__________|                      |__________|                      ())\n"
				+ "      ())         | |     ()       ____               | |      __        ____           | |      ___       _____     ())\n"
				+ "      ())         | |             / ___|              | |     /  \\      / ___|          | |     /   \\    /  __ \\     ()) \n"
				+ "      ())         | |     ||     /  /                 | |    / /\\ \\    /  /             | |    /  /\\ \\  /  /___/     ())\n"
				+ "      ())         | |     ||     \\  \\__               | |    \\ \\/  |   \\  \\__           | |    \\  \\/ /  \\  \\___      ())\n"
				+ "      ())         |_|     ||      \\____|              |_|     \\__| |    \\____|          |_|     \\___/    \\_____|     ())\n"
				+ "      ())                                                                                                            ())\n"
				+ "    ())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())())\n"
				+ "\n"
				+ "\n"
				+ "Welcome to Tic Tac Toe");
	}
	public static void boardreset() 
	{
		for(int i = 0;i<3;i++)
		{
			for(int ii =0; ii<3;ii++)
			{
				board[i][ii]=' ';
			}
		}		
	}
	public static void printboard() 
	{
		System.out.println("\n "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]
				+" \n---+---+---\n "
				+board[1][0]+" | "+board[1][1]+" | "+board[1][2]
				+" \n---+---+---\n "
				+board[2][0]+" | "+board[2][1]+" | "+board[2][2]+" ");
	}
	public static void putonboard(int spot,char letter,int player)
	{
		switch (spot)
		{
		case 1:
			if (board[0][0]==' ')
				board[0][0]= letter;
			else
			{
				if ((player==1)||player==2) 
				{
					System.out.println("Spot \"" + spot + "\" is already taken");
				}
				playerinput(player);
			}
			break;
		case 2:
			if (board[0][1]==' ')
				board[0][1]= letter;
			else
			{
				if ((player==1)||player==2) 
				{
					System.out.println("Spot \"" + spot + "\" is already taken");
				}
				playerinput(player);
			}
			break;
		case 3:
			if (board[0][2]==' ')
				board[0][2]= letter;
			else
			{
				if ((player==1)||player==2) 
				{
					System.out.println("Spot \"" + spot + "\" is already taken");
				}
				playerinput(player);
			}
			break;
		case 4:
			if (board[1][0]==' ')
				board[1][0]= letter;
			else
			{
				if ((player==1)||player==2) 
				{
					System.out.println("Spot \"" + spot + "\" is already taken");
				}
				playerinput(player);
			}
			break;
		case 5:
			if (board[1][1]==' ')
				board[1][1]= letter;
			else
			{
				if ((player==1)||player==2) 
				{
					System.out.println("Spot \"" + spot + "\" is already taken");
				}
				playerinput(player);
			}
			break;
		case 6:
			if (board[1][2]==' ')
				board[1][2]= letter;
			else
			{
				if ((player==1)||player==2) 
				{
					System.out.println("Spot \"" + spot + "\" is already taken");
				}
				playerinput(player);
			}
			break;
		case 7:
			if (board[2][0]==' ')
				board[2][0]= letter;
			else
			{
				if ((player==1)||player==2) 
				{
					System.out.println("Spot \"" + spot + "\" is already taken");
				}
				playerinput(player);
			}
			break;
		case 8:
			if (board[2][1]==' ')
				board[2][1]= letter;
			else
			{
				if ((player==1)||player==2) 
				{
					System.out.println("Spot \"" + spot + "\" is already taken");
				}
				playerinput(player);
			}
			break;
		case 9:
			if (board[2][2]==' ')
				board[2][2]= letter;
			else
			{
				if ((player==1)||player==2) 
				{
					System.out.println("Spot \"" + spot + "\" is already taken");
				}
				playerinput(player);
			}
			break;
		default:
			System.out.println("nope try again");
			playerinput(player);
			break;
		}
	}
	public static void playerinput(int player) 
	{
		Scanner in = new Scanner(System.in);
		if(player==1)
		{
			putonboard(in.nextInt(),'X',player);
		}
		else if(player==2)
		{
			putonboard(in.nextInt(),'O',player);
		}
		else if(player==3)
		{
			putonboard((int) (Math.random()*9)+1,'.',player);
		}
		else if(player==5)
		{
			putonboard(spotCOM(true),'0',player);
		}
		else if(player==6)
		{
			putonboard(COMfirst(),'i',player);
		}
		else
		{
			putonboard(spotCOM(false),'o',player);
		}
	}
	public static boolean wincheck() 
	{
		if ((board[0][0]==board[0][1])&& (board[0][1]==board[0][2])&&board[0][0]!=' ')
		{
			whowon=board[0][0];
			return true;
		}
		if ((board[1][0]==board[1][1])&& (board[1][1]==board[1][2])&&board[1][0]!=' ')
		{
			whowon=board[1][0];
			return true;
		}
		if ((board[2][0]==board[2][1])&& (board[2][1]==board[2][2])&&board[2][0]!=' ')
		{
			whowon=board[2][0];
			return true;
		}
		if ((board[0][0]==board[1][0])&& (board[1][0]==board[2][0])&&board[0][0]!=' ')
		{
			whowon=board[0][0];
			return true;
		}
		if ((board[0][1]==board[1][1])&& (board[1][1]==board[2][1])&&board[0][1]!=' ')
		{
			whowon=board[0][1];
			return true;
		}
		if ((board[0][2]==board[1][2])&& (board[1][2]==board[2][2])&&board[0][2]!=' ')
		{
			whowon=board[0][2];
			return true;
		}
		if ((board[0][0]==board[1][1])&& (board[1][1]==board[2][2])&&board[0][0]!=' ')
		{
			whowon=board[0][0];
			return true;
		}
		if ((board[0][2]==board[1][1])&& (board[1][1]==board[2][0])&&board[0][2]!=' ')
		{
			whowon=board[0][2];
			return true;
		}
		return false;
	}


	public static int COMfirst() 
	{
		for (int i = 0; i < 2; i++) 
		{
			char symbol='O';
			if(i==0)
				symbol='i';
			if ((board[0][0] == board[0][1]) && board[0][0] == symbol && board[0][2] == ' ') 
			{
				return 3;
			}
			if ((board[1][0] == board[1][1]) && board[1][0] == symbol && board[1][2] == ' ') 
			{
				return 6;
			}
			if ((board[2][0] == board[2][1]) && board[2][0] == symbol && board[2][2] == ' ') 
			{
				return 9;
			}
			if ((board[0][0] == board[1][0]) && board[0][0] == symbol && board[2][0] == ' ') 
			{
				return 7;
			}
			if ((board[0][1] == board[1][1]) && board[0][1] == symbol && board[2][1] == ' ') 
			{
				return 8;
			}
			if ((board[0][2] == board[1][2]) && board[0][2] == symbol && board[2][2] == ' ') 
			{
				return 9;
			}
			if ((board[0][0] == board[1][1]) && board[0][0] == symbol && board[2][2] == ' ') 
			{
				return 9;
			}
			if ((board[0][2] == board[1][1]) && board[0][2] == symbol && board[2][0] == ' ') 
			{
				return 7;
			}
			if ((board[0][0] == board[0][2]) && board[0][0] == symbol && board[0][1] == ' ') 
			{
				return 2;
			}
			if ((board[1][0] == board[1][2]) && board[1][0] == symbol && board[1][1] == ' ') 
			{
				return 5;
			}
			if ((board[2][0] == board[2][2]) && board[2][0] == symbol && board[2][1] == ' ') 
			{
				return 8;
			}
			if ((board[0][0] == board[2][0]) && board[0][0] == symbol && board[1][0] == ' ') 
			{
				return 4;
			}
			if ((board[0][1] == board[2][1]) && board[0][1] == symbol && board[1][1] == ' ') 
			{
				return 5;
			}
			if ((board[0][2] == board[2][2]) && board[0][2] == symbol && board[1][2] == ' ') 
			{
				return 6;
			}
			if ((board[0][0] == board[2][2]) && board[0][0] == symbol && board[1][1] == ' ') 
			{
				return 5;
			}
			if ((board[0][2] == board[2][0]) && board[0][2] == symbol && board[1][1] == ' ') 
			{
				return 5;
			}
			if ((board[0][1] == board[0][2]) && board[0][1] == symbol && board[0][0] == ' ') 
			{
				return 1;
			}
			if ((board[1][1] == board[1][2]) && board[1][1] == symbol && board[1][0] == ' ') 
			{
				return 4;
			}
			if ((board[2][1] == board[2][2]) && board[2][1] == symbol && board[2][0] == ' ') 
			{
				return 7;
			}
			if ((board[1][0] == board[2][0]) && board[1][0] == symbol && board[0][0] == ' ') 
			{
				return 1;
			}
			if ((board[1][1] == board[2][1]) && board[1][1] == symbol && board[0][1] == ' ') 
			{
				return 2;
			}
			if ((board[1][2] == board[2][2]) && board[1][2] == symbol && board[0][2] == ' ') 
			{
				return 3;
			}
			if ((board[1][1] == board[2][2]) && board[1][1] == symbol && board[0][0] == ' ') 
			{
				return 1;
			}
			if ((board[1][1] == board[2][0]) && board[1][1] == symbol && board[0][2] == ' ') 
			{
				return 3;
			} 
		}
		
		if(board[0][0]==' '&&board[0][2]==' '&&board[2][0]==' '&&board[2][2]==' ')
		{
			int whereto=(int)(Math.random()*4);
			if (whereto==0)
				return 1;
			if (whereto==1)
				return 3;
			if (whereto==2)
				return 7;
			if (whereto==3)
				return 9;
		}
		if (board[1][1]==' ')
		{
			int whereto=(int)(Math.random()*2);
			if (board[0][1]=='O') 
			{
				if (whereto == 0)
					return 7;
				if (whereto == 1)
					return 9;
			}
			if (board[1][0]=='O') 
			{
				if (whereto == 0)
					return 3;
				if (whereto == 1)
					return 9;
			}
			if (board[1][2]=='O') 
			{
				if (whereto == 0)
					return 1;
				if (whereto == 1)
					return 7;
			}
			if (board[2][1]=='O') 
			{
				if (whereto == 0)
					return 1;
				if (whereto == 1)
					return 3;
			}
			whereto=(int)(Math.random()*4);
			if (whereto==0)
				return 1;
			if (whereto==1)
				return 3;
			if (whereto==2)
				return 7;
			if (whereto==3)
				return 9;
		}
		return (((int) (Math.random()*9)+1));		
	}


}