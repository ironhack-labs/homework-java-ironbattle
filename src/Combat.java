public class Combat {
    public static void startCombat(Character char1,Character char2) {
        boolean finished = false;
        char1.setTeam(Team.A);
        char2.setTeam(Team.B);

        Bard.introducesStory();

        Character initChar1 = char1.clone();

        Bard.introducesFirstOpponent(char1);

        Character initChar2 = char2.clone();

        Bard.introducesSecondOpponent(char2);

        int roundCounter = 1;
        //Loop until one of the character wins
        while (!finished) {

            //Loop for the battle
            while (char1.isAlive() && char2.isAlive()) {
                Bard.announcesRound(roundCounter++);

                char1.attack(char2);
                Bard.narratesHp(char2);

                char2.attack(char1);
                Bard.narratesHp(char1);

                if (char1.getHp() <= 0) {
                    char1.setAlive(false);
                    Bard.announcesOpponentDeath(char1);
                }
                if (char2.getHp() <= 0) {
                    char2.setAlive(false);
                    Bard.announcesOpponentDeath(char2);
                }
            }

            //Once the battle is finished, let's check who wins the battle
            if (!char2.isAlive() && !char1.isAlive()) {
                //The battle result is a tie
                Bard.announcesTie();
                roundCounter = 0;
                char1 = initChar1.clone();
                char2 = initChar2.clone();

            } else if (!char2.isAlive()) {
                Bard.announcesOpponentVictory(char1);
                finished = true;
            } else if (!char1.isAlive()) {
                Bard.announcesOpponentVictory(char2);
                finished = true;
            }
        }
    }
}
