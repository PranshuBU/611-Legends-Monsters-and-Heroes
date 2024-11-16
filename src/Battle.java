/*
 * Battle.java
 * This class represents a turn-based battle between heroes and monsters in a game.
 * It manages the sequence of actions for each participant, allowing heroes to attack,
 * cast spells, use items, and change equipment. The battle progresses in turns
 * until either all heroes or all monsters are defeated. The class also distributes
 * rewards to the heroes if they win the battle.
 */


import java.util.List;
import java.util.Iterator;
import Items.*;
import Characters.Heroes.*;
import Characters.Monsters.Monster;
import Exception.InputHandler;

public class Battle {
    private List<Hero> heroes;
    private List<Monster> monsters;
    private boolean heroesWon;
    private InputHandler<Integer> intHandler;

    public Battle(List<Hero> heroes, List<Monster> monsters) {
        this.heroes = heroes;
        this.monsters = monsters;
        this.heroesWon = false;
        this.intHandler = new InputHandler<>(Integer.class);
    }

    public void startBattle() {
        System.out.println("Battle starts!");
        while (!isBattleOver()) {
            heroTurn();
            if (!isBattleOver()) {
                monsterTurn();
            }
            endRound();
        }
        endBattle();
    }

    private void performHeroAction(Hero hero) {
        System.out.println("\n" + hero.getName() + "'s turn:");

        if (hero instanceof Warrior) {
            System.out.println("1. Attack");
            System.out.println("2. Use Potion");
            System.out.println("3. Change Weapon/Armor");
            System.out.println("4. Show Info");

            int choice = intHandler.getInput("Choose an action (1-4): ", 1, 4);

            switch (choice) {
                case 1: heroAttacks(hero); break;
                case 2: heroUsePotion(hero); break;
                case 3: heroChangeEquipment(hero); break;
                case 4:
                    showBattleInfo();
                    performHeroAction(hero);
                    break;
            }
        } else {
            System.out.println("1. Attack");
            System.out.println("2. Cast Spell");
            System.out.println("3. Use Potion");
            System.out.println("4. Change Weapon/Armor");
            System.out.println("5. Show Info");

            int choice = intHandler.getInput("Choose an action (1-5): ", 1, 5);

            switch (choice) {
                case 1: heroAttacks(hero); break;
                case 2: heroCastsSpell(hero); break;
                case 3: heroUsePotion(hero); break;
                case 4: heroChangeEquipment(hero); break;
                case 5:
                    showBattleInfo();
                    performHeroAction(hero);
                    break;
            }
        }
    }

    private void heroAttacks(Hero hero) {
        Monster target = selectMonsterTarget();
        int damage = hero.getAttackDamage();
        if (!target.dodge()) {
            target.takeDamage(damage);
            System.out.println(hero.getName() + " attacked " + target.getName() + " for " + damage + " damage!");
        } else {
            System.out.println(target.getName() + " dodged the attack!");
        }
        
    }

    private void heroCastsSpell(Hero hero) {
        List<Spell> spells = hero.getSpells();
        if (spells.isEmpty()) {
            System.out.println(hero.getName() + " has no spells to cast!");
            return;
        }

        System.out.println("Choose a spell to cast:");
        for (int i = 0; i < spells.size(); i++) {
            System.out.println((i + 1) + ". " + spells.get(i));
        }

        int choice = intHandler.getInput("Select spell (1-" + spells.size() + "): ", 1, spells.size()) - 1;
        Spell spell = spells.get(choice);
        Monster target = selectMonsterTarget();
        int damage = hero.castSpell(spell, target);

        if (damage > 0) {
            System.out.println(hero.getName() + " cast " + spell.getName() + " on " + target.getName() + " for " + damage + " damage!");
        } else {
            System.out.println(hero.getName() + " doesn't have enough mana to cast " + spell.getName() + "!");
        }
    }

    private void heroUsePotion(Hero hero) {
        List<Potion> potions = hero.getPotions();
        if (potions.isEmpty()) {
            System.out.println(hero.getName() + " has no potions to use!");
            performHeroAction(hero);
            return;
        }

        System.out.println("Choose a potion to use:");
        for (int i = 0; i < potions.size(); i++) {
            System.out.println((i + 1) + ". " + potions.get(i));
        }

        int choice = intHandler.getInput("Select potion (1-" + potions.size() + "): ", 1, potions.size()) - 1;
        Potion potion = potions.get(choice);
        hero.usePotion(potion);
        System.out.println(hero.getName() + " used " + potion.getName() + "!");
    }

    private void heroChangeEquipment(Hero hero) {
        int choice = intHandler.getInput("1. Change Weapon\n2. Change Armor\nChoose an option (1-2): ", 1, 2);

        switch (choice) {
            case 1: changeWeapon(hero); break;
            case 2: changeArmor(hero); break;
        }
    }

    private void changeWeapon(Hero hero) {
        List<Weapon> weapons = hero.getWeapons();
        if (weapons.isEmpty()) {
            System.out.println(hero.getName() + " has no weapons to equip!");
            return;
        }

        System.out.println("Choose a weapon to equip:");
        for (int i = 0; i < weapons.size(); i++) {
            System.out.println((i + 1) + ". " + weapons.get(i));
        }

        int choice = intHandler.getInput("Select weapon (1-" + weapons.size() + "): ", 1, weapons.size()) - 1;
        Weapon weapon = weapons.get(choice);
        hero.equipWeapon(weapon);
        System.out.println(hero.getName() + " equipped " + weapon.getName() + "!");
    }

    private void changeArmor(Hero hero) {
        List<Armor> armors = hero.getArmors();
        if (armors.isEmpty()) {
            System.out.println(hero.getName() + " has no armor to equip!");
            return;
        }

        System.out.println("Choose an armor to equip:");
        for (int i = 0; i < armors.size(); i++) {
            System.out.println((i + 1) + ". " + armors.get(i));
        }

        int choice = intHandler.getInput("Select armor (1-" + armors.size() + "): ", 1, armors.size()) - 1;
        Armor armor = armors.get(choice);
        hero.equipArmor(armor);
        System.out.println(hero.getName() + " equipped " + armor.getName() + "!");
    }

    private Monster selectMonsterTarget() {
        System.out.println("Select a monster to target:");
        for (int i = 0; i < monsters.size(); i++) {
            System.out.println((i + 1) + ". " + monsters.get(i).getName() + " [HP: " + monsters.get(i).getHp() + "]");
        }
        int choice = intHandler.getInput("Select target (1-" + monsters.size() + "): ", 1, monsters.size()) - 1;
        return monsters.get(choice);
    }

    private boolean isBattleOver() {
        return areAllHeroesFainted() || areAllMonstersDead();
    }

    private void heroTurn() {
        for (Hero hero : heroes) {
            if (hero.isAlive()) {
                performHeroAction(hero);
            }
        }
    }

    private void monsterTurn() {
        for (Monster monster : monsters) {
            if (monster.isAlive()) {
                Hero target = heroes.get((int) (Math.random() * heroes.size()));
                int damage = monster.attack();
                if (!target.dodge()) {
                    target.takeDamage(damage);
                    System.out.println(monster.getName() + " attacked " + target.getName() + " for " + damage + " damage!");
                    if (!target.isAlive()) {
                        System.out.println(target.getName() + " fainted!");
                    }
                } else {
                    System.out.println(target.getName() + " dodged the attack!");
                }
            }
        }
    }

    private void endRound() {
        for (Hero hero : heroes) {
            if (hero.isAlive()) {
                hero.heal((int) (hero.getMaxHp() * 0.1));
                hero.restoreMana((int) (hero.getMaxMp() * 0.1));
            }
        }
        removeDefeatedMonsters();
    }

    private void removeDefeatedMonsters() {
        Iterator<Monster> iterator = monsters.iterator();
        while (iterator.hasNext()) {
            Monster monster = iterator.next();
            if (!monster.isAlive()) {
                System.out.println(monster.getName() + " has been defeated!");
                iterator.remove();
            }
        }
    }

    private void endBattle() {
        heroesWon = !areAllHeroesFainted();
        if (heroesWon) {
            System.out.println("Heroes won the battle!");
            distributeRewards();
        } else {
            System.out.println("Heroes were defeated...");
        }
    }

    private void distributeRewards() {
        int totalExperience = monsters.size() * 2;
        int totalGold = 0;
        for (Monster monster : monsters) {
            totalGold += monster.getLevel() * 100;
        }

        for (Hero hero : heroes) {
            if (hero.isAlive()) {
                hero.gainExperience(totalExperience);
                hero.gainGold(totalGold);
            } else {
                hero.revive();
            }
        }
    }

    private boolean areAllHeroesFainted() {
        return heroes.stream().noneMatch(Hero::isAlive);
    }

    private boolean areAllMonstersDead() {
        return monsters.isEmpty();
    }

    private void showBattleInfo() {
        System.out.println("\nHeroes:");
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
        System.out.println("\nMonsters:");
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
    }

    public boolean isHeroesWon() {
        return heroesWon;
    }
}