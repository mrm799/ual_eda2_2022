

public class Player{

    private String playerName;
    private ArrayList<String> teams;
    private ArrayList<String> positions;
    private int score;

    public Player(String playerName, String team, String position, int score){
        this.playerName = playerName;
        this.teams = new ArrayList<String>();
        this.teams.add(team);
        this.positions = new ArrayList<String>();
        this.positions.add(position);
        this.score = score;
    }

    public String getPlayerName(){
        return this.playerName;
    }
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public ArrayList<String> getTeams(){
        return this.teams;
    }
    public void setTeams(ArrayList<String> teams){
        this.teams = teams;
    }

    public ArrayList<String> getPositions(){
        return this.positions;
    }
    public void setPositions(ArrayList<String> positions){
        this.positions = positions;
    }

    public int getScore(){
        return this.score;
    }
    public void setScore(int score){
        this.score = score;
    }
}