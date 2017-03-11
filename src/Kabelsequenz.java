import java.util.InputMismatchException;

public class Kabelsequenz {
	int rot;
	int blau;
	int schwarz;
	
	public Kabelsequenz()
	{
		this.rot = 0;
		this.blau = 0;
		this.schwarz = 0;
	}
	
	public boolean cutCable(char color, char pos) throws InputMismatchException
	{
		if(color == 'r')
		{
			this.rot++;
			if(pos == 'a')
			{
				if(this.rot == 3 || this.rot == 4 || this.rot == 6 || this.rot == 7 || this.rot == 8)
					return true;
				else return false;
			}
			else if (pos == 'b')
			{
				if(this.rot == 2 || this. rot == 5 || this.rot == 7 || this.rot == 8 || this.rot == 9)
					return true;
				else return false;
			}
			else if (pos == 'c')
				if(this.rot == 1 || this.rot == 4 || this.rot == 6 || this.rot == 7)
					return true;
				else return false;
		}
		else if (color == 'b')
		{
			this.blau++;
			if (pos == 'a')
			{
				if(this.blau == 2 || this.blau == 4 || this.blau == 8 || this.blau == 9)
					return true;
				else return false;
			}
			else if (pos == 'b')
			{
				if(this.blau == 1 || this.blau == 3 || this.blau == 5 || this.blau == 6)
					return true;
				else return false;
			}
			else if (pos == 'c')
			{
				if(this.blau == 2 || this.blau == 6 || this.blau == 7 || this.blau == 8)
					return true;
				else return false;
			}
		}
		else if (color == 's')
		{
			this.schwarz++;
			if (pos == 'a')
			{
				if(this.schwarz == 1 || this.schwarz == 2 || this.schwarz == 4 || this.schwarz == 7)
					return true;
				else return false;
			}
			else if (pos == 'b')
			{
				if(this.schwarz == 1 || this.schwarz == 3 || this.schwarz == 5 || this.schwarz == 6 || this.schwarz == 7)
					return true;
				else return false;
			}
			else if (pos == 'c')
			{
				if(this.schwarz == 1 || this.schwarz == 2 || this.schwarz == 4 || this.schwarz == 6 || this.schwarz == 8 || this.schwarz == 9)
					return true;
				else return false;
			}
		}
		if(color != 'r' && color != 'b' && color != 's')
			throw new InputMismatchException("Error: Please enter a valid color.");
		if(pos != 'a' && pos != 'b' && pos != 'c')
			throw new InputMismatchException("Error: Please enter a valid position.");
		throw new InputMismatchException("Error: Unknown error!");
	}
}
