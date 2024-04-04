import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelUpController {

    private LevelUpView levelUpView;
    private MCharacter character;

    public LevelUpController (GameLobbyModel model, GameLobbyController gameLobbyController)
    {
        character = model.returnMCharacter();
        levelUpView = new LevelUpView(model, this);

        levelUpView.addLevHpListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (character.getHealthPoints() != 50) {
                    if (character.getnRunes() >= upCost()) {
                        levelUpView.disposeLevelUpView();
                        character.setHealthPoints(character.getHealthPoints() + 1);
                        character.setnRunes(character.getnRunes() - upCost());
                        character.setCharacterLevel(character.getCharacterLevel() + 1);
                        gameLobbyController.updateGameLobby();
                        gameLobbyController.initiateGameLobby();
                    } else {
                        JOptionPane.showMessageDialog(null, "You do not have enough Runes", "Note", JOptionPane.ERROR_MESSAGE);
                    }
                } else
                {
                    JOptionPane.showMessageDialog(null, "Your health is already at its maximum level.", "Note", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        levelUpView.addLevEndListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (character.getEndurance() != 50) {
                    if (character.getnRunes() >= upCost()) {
                        levelUpView.disposeLevelUpView();
                        character.setEndurance(character.getEndurance() + 1);
                        character.setnRunes(character.getnRunes() - upCost());
                        character.setCharacterLevel(character.getCharacterLevel() + 1);
                        gameLobbyController.updateGameLobby();
                        gameLobbyController.initiateGameLobby();
                    } else {
                        JOptionPane.showMessageDialog(null, "You do not have enough Runes", "Note", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Your endurance is already at its maximum level.", "Note", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        levelUpView.addLevDexListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (character.getDexterity() != 50) {
                    if (character.getnRunes() >= upCost()) {
                        levelUpView.disposeLevelUpView();
                        character.setDexterity(character.getDexterity() + 1);
                        character.setnRunes(character.getnRunes() - upCost());
                        character.setCharacterLevel(character.getCharacterLevel() + 1);
                        gameLobbyController.updateGameLobby();
                        gameLobbyController.initiateGameLobby();
                    } else {
                        JOptionPane.showMessageDialog(null, "You do not have enough Runes", "Note", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Your dexterity is already at its maximum level.", "Note", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        levelUpView.addLevStrListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (character.getStrength() != 50) {

                    if (character.getnRunes() >= upCost()) {
                        levelUpView.disposeLevelUpView();
                        character.setStrength(character.getStrength() + 1);
                        character.setnRunes(character.getnRunes() - upCost());
                        character.setCharacterLevel(character.getCharacterLevel() + 1);
                        gameLobbyController.updateGameLobby();
                        gameLobbyController.initiateGameLobby();
                    } else {
                        JOptionPane.showMessageDialog(null, "You do not have enough Runes", "Note", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Your strength is already at its maximum level.", "Note", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        levelUpView.addLevIntListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (character.getIntelligence() != 50) {
                    if (character.getnRunes() >= upCost()) {
                        levelUpView.disposeLevelUpView();
                        character.setIntelligence(character.getIntelligence() + 1);
                        character.setnRunes(character.getnRunes() - upCost());
                        character.setCharacterLevel(character.getCharacterLevel() + 1);
                        gameLobbyController.updateGameLobby();
                        gameLobbyController.initiateGameLobby();
                    } else {
                        JOptionPane.showMessageDialog(null, "You do not have enough Runes", "Note", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Your intelligence is already at its maximum level.", "Note", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        levelUpView.addLevFthListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (character.getFaith() != 50) {
                    if (character.getnRunes() >= upCost()) {
                        levelUpView.disposeLevelUpView();
                        character.setFaith(character.getFaith() + 1);
                        character.setnRunes(character.getnRunes() - upCost());
                        character.setCharacterLevel(character.getCharacterLevel() + 1);
                        gameLobbyController.updateGameLobby();
                        gameLobbyController.initiateGameLobby();
                    } else {
                        JOptionPane.showMessageDialog(null, "You do not have enough Runes", "Note", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Your faith is already at its maximum level.", "Note", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        levelUpView.addBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                levelUpView.disposeLevelUpView();
                gameLobbyController.updateGameLobby();
                gameLobbyController.initiateGameLobby();
            }
        });

    }

    public double upCost () {
        return (double) (this.character.getCharacterLevel() * 100) / 2;
    }

    public void inititaeLevelUp ()
    {
        levelUpView.initiateLevelView();
    }

    public void updateLevelUpView ()
    {
        levelUpView.updateView();
    }

}
