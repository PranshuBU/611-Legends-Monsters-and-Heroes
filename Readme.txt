# CS611-Assignment < 4 >
## < Legends:Monsters and Heroes>
---------------------------------------------------------------------------
- Name: Pranshu Swaroop
- Email: spranshu@bu.edu
- Student ID: U95602215

## Files
--------------------------------------------------------------------

1.Game.java: Represents a general game with attributes like name, level, and health points (HP).
	  Provides methods for managing HP, taking damage, healing, leveling up, and checking if the character is alive.
          Specific character types, such as heroes and monsters, extend this class with unique stats and behaviors.

2.Hero.java: Defines a hero character with attributes like health, mana, strength, dexterity, agility, experience, and gold.
	 Allows heroes to level up, use items, equip weapons and armor, cast spells, and move across the game board. 
	Provides methods for managing inventory, calculating damage, gaining experience and gold, and interacting with game elements.

3.Warrior.java: Represents a Warrior hero, focused on strength and agility for effective physical combat.
	 Overrides methods for calculating stats, leveling up, and getting attack damage with Warrior-specific bonuses.


4.Battle.java:This class represents a turn-based battle between heroes and monsters in a game.
	It manages the sequence of actions for each participant, allowing heroes to attack,
 	cast spells, use items, and change equipment. The battle progresses in turns
 	until either all heroes or all monsters are defeated. The class also distributes
  	rewards to the heroes if they win the battle.



5.Paladin.java: Defines a Paladin hero characterized by high strength and dexterity, effective in physical combat. 
		Applies Paladin-specific bonuses for enhanced attack damage and spell effectiveness by overriding key methods.

6.Sorcerer.java: Represents a Sorcerer hero, a specialized spellcaster with high mana, agility, and dexterity.
		 Enhances spell damage by applying Sorcerer-specific bonuses to spellcasting, leveling up, and stat calculation.

7.Monster.java: Defines the attributes and behaviors of monsters with base damage, defense, and dodge chance.
		 Allows specific monster types to implement unique stats and abilities by providing methods for attacking, defending, and dodging.

8.Spirit.java: Represents a Spirit monster, with enhanced dodge capabilities and balanced stats that scale with level.
		 Provides unique behavior by adding an extra dodge chance and scaling stats for Spirits.

9.Exoskeleton.java: Defines an Exoskeleton monster with enhanced defense and a chance to reduce incoming damage. 
		Provides Exoskeleton-specific defenses by overriding methods to calculate stats and enhance damage reduction.

10.Dragon.java: Represents a Dragon monster known for high base damage and a chance to use a powerful fire breath attack. 
	Increases base damage and fire breath attack damage by 50% with a 20% chance of activation, creating unique combat behavior.

11 Item.java: Defines common attributes and behaviors for items used by heroes, with name, price, level, and uses. 
	Allows specific item types, such as Armor and Weapon, to extend and implement unique behaviors by providing methods to use items, check usability, and display item details.

12 Armor.java: Represents armor items that reduce incoming damage when equipped by heroes.
	 Provides methods to display armor details, get item type, and manage protection by extending the base Item class with damage reduction.

13 Potion.java: Defines a healing potion that restores health for heroes, with a healing amount and a single use. 
		Provides methods to display potion details, check usability, and apply healing effects when used by heroes.

14 Spell.java: Represents a spell that heroes use to deal damage and apply effects on monsters, with a damage value, mana cost, and type.
	 Provides methods to apply type-based effects, such as reducing the target’s damage, defense, or dodge chance, and to display spell details.

15 Weapon.java: Defines weapons that increase heroes' attack damage, with base damage and hand requirements. 
		Provides methods to calculate scaled damage, retrieve item type, and display weapon details.

16 InputHandler.java: A utility class for handling various types of user input with validation.
		Supports type-specific parsing, range validation, selection from options, and case-insensitive string comparison.

17 Market.java: Represents a marketplace where heroes can buy and sell items, with a random selection of items for sale.
		Provides methods to display items, handle transactions, and validate heroes’ inventory and gold for purchases.

18 World.java: Defines the game world as a grid of spaces, with inaccessible areas, markets, and common spaces.
	Provides methods to display the grid, track hero positions, validate movements, and identify specific space types for interactions.

19 HeroFactory.java: A factory class for creating various hero types, including random and specific hero creation.
		Provides methods to generate random heroes at a specified level or create heroes of a specified type, such as Warrior or Paladin.

20 MonsterFactory.java: A factory class for creating various types of monsters, including random and specific monster creation.
Provides methods to generate random monsters or create specified types, such as Dragon, Exoskeleton, or Spirit.

21 CharacterFactory: An interface that defines a factory for creating game characters. It includes a single method, `createCharacter`, which takes a name and level as parameters and returns an instance of a `GameCharacter`. This interface allows for flexibility in creating different character types, such as heroes or monsters, by implementing specific factory classes.
22 CommonSpace.java:Represents a common space in the game where battles can occur with a 20% probability.
 When a hero enters, it may trigger a battle, indicated by the `hasBattle` attribute.
 The class provides methods to check if a battle is active, reset the battle state, and display the symbol for common spaces.

23 InaccessibleSpace.java:Represents an inaccessible space in the game where heroes cannot enter.
  When a hero attempts to enter, it displays an error message indicating that entry is not allowed.
  This class provides a symbol to represent inaccessible spaces in the game grid.

24 Market.java:This class represents a market where heroes can buy and sell items.
 It generates a random selection of items for sale and allows heroes to interact
 with the market to purchase or sell equipment such as weapons, armor, potions, and spells.
 The class includes methods to display available items, handle transactions, and
 validate hero inventory and gold for purchases.

25 MarketSpace.java:Represents a market space in the game where heroes can access a marketplace.
When a hero enters, it prompts the player to enter the market.
The class provides methods to display the market symbol, retrieve the market,
and allow a hero to interact with the market for buying and selling items.

26 Position.java:Represents a coordinate in the game grid with `x` and `y` values to define a location.
This class is used to track and manage the position of characters and other entities within the game world.

27 Space.java:An abstract class that represents a space within the game world,
 characterized by whether it is accessible and whether it contains a market.
 The class provides abstract methods for retrieving the space's symbol and defining behavior
 when a hero enters the space. Specific types of spaces, like MarketSpace and CommonSpace,
 extend this class with specialized behaviors.

28.Main: The entry point of the application that initializes and starts the game. 
It creates an instance of the Game class and calls its start method to begin gameplay.
## How to compile and run
---------------------------------------------------------------------------
1) Unzip the zip folder
2) Run the Main.java in IntelliJ 


## Input/Output Example
-----------------------------------------------------------------------------
Number of heroes in your team? (choose between 1-3): 2
Enter hero's name: Batman
Choose hero type (Warrior/Sorcerer/Paladin): warrior
Enter hero's name: Joker
Choose hero type (Warrior/Sorcerer/Paladin): Sorcerer
M  C  C  X  C  X  M  M  
M  M  M  X  C  C  C  M  
C  M  C  C  C  M  C  C  
X  C  C  X  X  M  X  X  
C  X  C  X  JO M  M  C  
X  M  C  C  C  C  BA C  
C  M  C  C  C  X  M  C  
M  C  C  M  C  M  M  M  
Enter move (W/A/S/D) or options (I/M/Q): w
Cannot move in that direction.
M  C  C  X  C  X  M  M  
M  M  M  X  C  C  C  M  
C  M  C  C  C  M  C  C  
X  C  C  X  X  M  X  X  
C  X  C  X  JO M  M  C  
X  M  C  C  C  C  BA C  
C  M  C  C  C  X  M  C  
M  C  C  M  C  M  M  M  
Enter move (W/A/S/D) or options (I/M/Q): w
Cannot move in that direction.
M  C  C  X  C  X  M  M  
M  M  M  X  C  C  C  M  
C  M  C  C  C  M  C  C  
X  C  C  X  X  M  X  X  
C  X  C  X  JO M  M  C  
X  M  C  C  C  C  BA C  
C  M  C  C  C  X  M  C  
M  C  C  M  C  M  M  M  
Enter move (W/A/S/D) or options (I/M/Q): w
Cannot move in that direction.
M  C  C  X  C  X  M  M  
M  M  M  X  C  C  C  M  
C  M  C  C  C  M  C  C  
X  C  C  X  X  M  X  X  
C  X  C  X  JO M  M  C  
X  M  C  C  C  C  BA C  
C  M  C  C  C  X  M  C  
M  C  C  M  C  M  M  M  
Enter move (W/A/S/D) or options (I/M/Q): w
Cannot move in that direction.
M  C  C  X  C  X  M  M  
M  M  M  X  C  C  C  M  
C  M  C  C  C  M  C  C  
X  C  C  X  X  M  X  X  
C  X  C  X  JO M  M  C  
X  M  C  C  C  C  BA C  
C  M  C  C  C  X  M  C  
M  C  C  M  C  M  M  M  
Enter move (W/A/S/D) or options (I/M/Q): s
Batman moved S
Joker moved S
M  C  C  X  C  X  M  M  
M  M  M  X  C  C  C  M  
C  M  C  C  C  M  C  C  
X  C  C  X  X  M  X  X  
C  X  C  X  M  M  M  C  
X  M  C  C  JO C  C  C  
C  M  C  C  C  X  BA C  
M  C  C  M  C  M  M  M  
Enter move (W/A/S/D) or options (I/M/Q): w
Batman moved W
Joker moved W
M  C  C  X  C  X  M  M  
M  M  M  X  C  C  C  M  
C  M  C  C  C  M  C  C  
X  C  C  X  X  M  X  X  
C  X  C  X  JO M  M  C  
X  M  C  C  C  C  BA C  
C  M  C  C  C  X  M  C  
M  C  C  M  C  M  M  M  
Enter move (W/A/S/D) or options (I/M/Q): a
Cannot move in that direction.
M  C  C  X  C  X  M  M  
M  M  M  X  C  C  C  M  
C  M  C  C  C  M  C  C  
X  C  C  X  X  M  X  X  
C  X  C  X  JO M  M  C  
X  M  C  C  C  C  BA C  
C  M  C  C  C  X  M  C  
M  C  C  M  C  M  M  M  
Enter move (W/A/S/D) or options (I/M/Q): a
Cannot move in that direction.
M  C  C  X  C  X  M  M  
M  M  M  X  C  C  C  M  
C  M  C  C  C  M  C  C  
X  C  C  X  X  M  X  X  
C  X  C  X  JO M  M  C  
X  M  C  C  C  C  BA C  
C  M  C  C  C  X  M  C  
M  C  C  M  C  M  M  M  
Enter move (W/A/S/D) or options (I/M/Q): s
Batman moved S
Joker moved S
M  C  C  X  C  X  M  M  
M  M  M  X  C  C  C  M  
C  M  C  C  C  M  C  C  
X  C  C  X  X  M  X  X  
C  X  C  X  M  M  M  C  
X  M  C  C  JO C  C  C  
C  M  C  C  C  X  BA C  
M  C  C  M  C  M  M  M  
Enter move (W/A/S/D) or options (I/M/Q): a
Cannot move in that direction.
M  C  C  X  C  X  M  M  
M  M  M  X  C  C  C  M  
C  M  C  C  C  M  C  C  
X  C  C  X  X  M  X  X  
C  X  C  X  M  M  M  C  
X  M  C  C  JO C  C  C  
C  M  C  C  C  X  BA C  
M  C  C  M  C  M  M  M  
Enter move (W/A/S/D) or options (I/M/Q): d
Batman moved D
Joker moved D
Battle starts!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 1
Select a monster to target:
1. Monster 1 [HP: 100]
2. Monster 2 [HP: 100]
Select target (1-2): 1
Batman attacked Monster 1 for 5 damage!

Joker's turn:
1. Attack
2. Cast Spell
3. Use Potion
4. Change Weapon/Armor
5. Show Info
Choose an action (1-5): 2
Choose a spell to cast:
1. Flame Thrower (Level 1 fire Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
2. Ice Beam (Level 1 ice Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
Select spell (1-2): 1
Select a monster to target:
1. Monster 1 [HP: 100]
2. Monster 2 [HP: 100]
Select target (1-2): 1
Monster 1's defense has been reduced!
Joker cast Flame Thrower on Monster 1 for 43 damage!
Monster 1 attacked Joker for 21 damage!
Monster 2 attacked Joker for 10 damage!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 2
Choose a potion to use:
1. Health Potion (Level 1 Potion) - Heals: 80 HP, Price: 100 gold, Uses left: 1
2. Mana Potion (Level 1 Potion) - Heals: 80 HP, Price: 100 gold, Uses left: 1
Select potion (1-2): 2
Batman used Mana Potion and healed for 80 HP.
Batman used Mana Potion!

Joker's turn:
1. Attack
2. Cast Spell
3. Use Potion
4. Change Weapon/Armor
5. Show Info
Choose an action (1-5): 1
Select a monster to target:
1. Monster 1 [HP: 75]
2. Monster 2 [HP: 100]
Select target (1-2): 1
Joker attacked Monster 1 for 5 damage!
Monster 1 attacked Batman for 25 damage!
Monster 2 attacked Batman for 16 damage!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 1
Select a monster to target:
1. Monster 1 [HP: 75]
2. Monster 2 [HP: 100]
Select target (1-2): 1
Batman attacked Monster 1 for 5 damage!

Joker's turn:
1. Attack
2. Cast Spell
3. Use Potion
4. Change Weapon/Armor
5. Show Info
Choose an action (1-5): 1
Select a monster to target:
1. Monster 1 [HP: 75]
2. Monster 2 [HP: 100]
Select target (1-2): 2
Joker attacked Monster 2 for 5 damage!
Monster 1 attacked Batman for 14 damage!
Monster 2 attacked Batman for 18 damage!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 1
Select a monster to target:
1. Monster 1 [HP: 75]
2. Monster 2 [HP: 100]
Select target (1-2): 2
Batman attacked Monster 2 for 5 damage!

Joker's turn:
1. Attack
2. Cast Spell
3. Use Potion
4. Change Weapon/Armor
5. Show Info
Choose an action (1-5): 2
Choose a spell to cast:
1. Flame Thrower (Level 1 fire Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
2. Ice Beam (Level 1 ice Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
Select spell (1-2): 
Invalid input. Enter a valid Integer.
Select spell (1-2): 2
Select a monster to target:
1. Monster 1 [HP: 75]
2. Monster 2 [HP: 100]
Select target (1-2): 1
Monster 1's damage has been reduced!
Joker cast Ice Beam on Monster 1 for 43 damage!
Monster 1 attacked Batman for 22 damage!
Monster 2 attacked Joker for 13 damage!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 2
Choose a potion to use:
1. Health Potion (Level 1 Potion) - Heals: 80 HP, Price: 100 gold, Uses left: 1
Select potion (1-1): 2
Please enter a value between 1 and 1
Select potion (1-1): 1
Batman used Health Potion and healed for 80 HP.
Batman used Health Potion!

Joker's turn:
1. Attack
2. Cast Spell
3. Use Potion
4. Change Weapon/Armor
5. Show Info
Choose an action (1-5): 2
Choose a spell to cast:
1. Flame Thrower (Level 1 fire Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
2. Ice Beam (Level 1 ice Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
Select spell (1-2): 2
Select a monster to target:
1. Monster 1 [HP: 49]
2. Monster 2 [HP: 100]
Select target (1-2): 1
Monster 1's damage has been reduced!
Joker cast Ice Beam on Monster 1 for 43 damage!
Monster 1 attacked Batman for 9 damage!
Monster 2 attacked Joker for 15 damage!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 2
Batman has no potions to use!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 2
Batman has no potions to use!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 1
Select a monster to target:
1. Monster 1 [HP: 23]
2. Monster 2 [HP: 100]
Select target (1-2): 2
Batman attacked Monster 2 for 5 damage!

Joker's turn:
1. Attack
2. Cast Spell
3. Use Potion
4. Change Weapon/Armor
5. Show Info
Choose an action (1-5): 2
Choose a spell to cast:
1. Flame Thrower (Level 1 fire Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
2. Ice Beam (Level 1 ice Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
Select spell (1-2): 2
Select a monster to target:
1. Monster 1 [HP: 23]
2. Monster 2 [HP: 100]
Select target (1-2): 2
Monster 2's damage has been reduced!
Joker cast Ice Beam on Monster 2 for 43 damage!
Joker dodged the attack!
Monster 1 attacked Joker for 16 damage!
Monster 2 attacked Joker for 13 damage!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 1
Select a monster to target:
1. Monster 1 [HP: 23]
2. Monster 2 [HP: 83]
Select target (1-2): 2
Batman attacked Monster 2 for 5 damage!

Joker's turn:
1. Attack
2. Cast Spell
3. Use Potion
4. Change Weapon/Armor
5. Show Info
Choose an action (1-5): 2
Choose a spell to cast:
1. Flame Thrower (Level 1 fire Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
2. Ice Beam (Level 1 ice Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
Select spell (1-2): 2
Select a monster to target:
1. Monster 1 [HP: 23]
2. Monster 2 [HP: 83]
Select target (1-2): 2
Monster 2 dodged the attack!
Monster 2's damage has been reduced!
Joker cast Ice Beam on Monster 2 for 43 damage!
Monster 1 attacked Joker for 15 damage!
Monster 2 attacked Batman for 11 damage!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 1
Select a monster to target:
1. Monster 1 [HP: 23]
2. Monster 2 [HP: 83]
Select target (1-2): 1
Batman attacked Monster 1 for 5 damage!

Joker's turn:
1. Attack
2. Cast Spell
3. Use Potion
4. Change Weapon/Armor
5. Show Info
Choose an action (1-5): 2
Choose a spell to cast:
1. Flame Thrower (Level 1 fire Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
2. Ice Beam (Level 1 ice Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
Select spell (1-2): 1
Select a monster to target:
1. Monster 1 [HP: 23]
2. Monster 2 [HP: 83]
Select target (1-2): 1
Monster 1 dodged the attack!
Monster 1's defense has been reduced!
Joker cast Flame Thrower on Monster 1 for 43 damage!
Monster 1 attacked Batman for 19 damage!
Monster 2 attacked Batman for 5 damage!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 1
Select a monster to target:
1. Monster 1 [HP: 23]
2. Monster 2 [HP: 83]
Select target (1-2): 2
Batman attacked Monster 2 for 5 damage!

Joker's turn:
1. Attack
2. Cast Spell
3. Use Potion
4. Change Weapon/Armor
5. Show Info
Choose an action (1-5): 2
Choose a spell to cast:
1. Flame Thrower (Level 1 fire Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
2. Ice Beam (Level 1 ice Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
Select spell (1-2): 2
Select a monster to target:
1. Monster 1 [HP: 23]
2. Monster 2 [HP: 83]
Select target (1-2): 1
Monster 1 dodged the attack!
Monster 1's damage has been reduced!
Joker cast Ice Beam on Monster 1 for 43 damage!
Monster 1 attacked Batman for 11 damage!
Monster 2 attacked Batman for 9 damage!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 2
Batman has no potions to use!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 1
Select a monster to target:
1. Monster 1 [HP: 23]
2. Monster 2 [HP: 83]
Select target (1-2): 2
Batman attacked Monster 2 for 5 damage!

Joker's turn:
1. Attack
2. Cast Spell
3. Use Potion
4. Change Weapon/Armor
5. Show Info
Choose an action (1-5): 2
Choose a spell to cast:
1. Flame Thrower (Level 1 fire Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
2. Ice Beam (Level 1 ice Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
Select spell (1-2): 1
Select a monster to target:
1. Monster 1 [HP: 23]
2. Monster 2 [HP: 83]
Select target (1-2): 2
Monster 2's defense has been reduced!
Joker cast Flame Thrower on Monster 2 for 43 damage!
Monster 1 attacked Batman for 15 damage!
Monster 2 attacked Batman for 10 damage!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 
Invalid input. Enter a valid Integer.
Choose an action (1-4): 1
Select a monster to target:
1. Monster 1 [HP: 23]
2. Monster 2 [HP: 66]
Select target (1-2): 2
Batman attacked Monster 2 for 5 damage!

Joker's turn:
1. Attack
2. Cast Spell
3. Use Potion
4. Change Weapon/Armor
5. Show Info
Choose an action (1-5): 1
Select a monster to target:
1. Monster 1 [HP: 23]
2. Monster 2 [HP: 66]
Select target (1-2): 2
Joker attacked Monster 2 for 5 damage!
Monster 1 attacked Batman for 19 damage!
Monster 2 attacked Joker for 9 damage!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 1
Select a monster to target:
1. Monster 1 [HP: 23]
2. Monster 2 [HP: 66]
Select target (1-2): 2
Batman attacked Monster 2 for 5 damage!

Joker's turn:
1. Attack
2. Cast Spell
3. Use Potion
4. Change Weapon/Armor
5. Show Info
Choose an action (1-5): 2
Choose a spell to cast:
1. Flame Thrower (Level 1 fire Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
2. Ice Beam (Level 1 ice Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
Select spell (1-2): 2
Select a monster to target:
1. Monster 1 [HP: 23]
2. Monster 2 [HP: 66]
Select target (1-2): 2
Monster 2's damage has been reduced!
Joker cast Ice Beam on Monster 2 for 43 damage!
Monster 1 uses fire breath!
Monster 1 attacked Batman for 24 damage!
Monster 2 attacked Batman for 8 damage!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 1
Select a monster to target:
1. Monster 1 [HP: 23]
2. Monster 2 [HP: 47]
Select target (1-2): 1
Batman attacked Monster 1 for 5 damage!

Joker's turn:
1. Attack
2. Cast Spell
3. Use Potion
4. Change Weapon/Armor
5. Show Info
Choose an action (1-5): 2
Choose a spell to cast:
1. Flame Thrower (Level 1 fire Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
2. Ice Beam (Level 1 ice Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
Select spell (1-2): 2
Select a monster to target:
1. Monster 1 [HP: 23]
2. Monster 2 [HP: 47]
Select target (1-2): 1
Monster 1's damage has been reduced!
Joker cast Ice Beam on Monster 1 for 43 damage!
Monster 2 attacked Batman for 9 damage!
Monster 1 has been defeated!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 2
Batman has no potions to use!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 2
Batman has no potions to use!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 1
Select a monster to target:
1. Monster 2 [HP: 47]
Select target (1-1): 2
Please enter a value between 1 and 1
Select target (1-1): 1
Batman attacked Monster 2 for 5 damage!

Joker's turn:
1. Attack
2. Cast Spell
3. Use Potion
4. Change Weapon/Armor
5. Show Info
Choose an action (1-5): 2
Choose a spell to cast:
1. Flame Thrower (Level 1 fire Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
2. Ice Beam (Level 1 ice Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
Select spell (1-2): 1
Select a monster to target:
1. Monster 2 [HP: 47]
Select target (1-1): 1
Monster 2's defense has been reduced!
Joker cast Flame Thrower on Monster 2 for 43 damage!
Monster 2 attacked Batman for 10 damage!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 2
Batman has no potions to use!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 1
Select a monster to target:
1. Monster 2 [HP: 28]
Select target (1-1): 2
Please enter a value between 1 and 1
Select target (1-1): 1
Batman attacked Monster 2 for 5 damage!

Joker's turn:
1. Attack
2. Cast Spell
3. Use Potion
4. Change Weapon/Armor
5. Show Info
Choose an action (1-5): 2
Choose a spell to cast:
1. Flame Thrower (Level 1 fire Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
2. Ice Beam (Level 1 ice Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
Select spell (1-2): 1
Select a monster to target:
1. Monster 2 [HP: 28]
Select target (1-1): 1
Monster 2's defense has been reduced!
Joker cast Flame Thrower on Monster 2 for 43 damage!
Monster 2 attacked Joker for 9 damage!

Batman's turn:
1. Attack
2. Use Potion
3. Change Weapon/Armor
4. Show Info
Choose an action (1-4): 1
Select a monster to target:
1. Monster 2 [HP: 7]
Select target (1-1): 1
Batman attacked Monster 2 for 5 damage!

Joker's turn:
1. Attack
2. Cast Spell
3. Use Potion
4. Change Weapon/Armor
5. Show Info
Choose an action (1-5): 2
Choose a spell to cast:
1. Flame Thrower (Level 1 fire Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
2. Ice Beam (Level 1 ice Spell) - Damage: 35, Mana Cost: 20, Price: 150 gold, Uses left: 35
Select spell (1-2): 1
Select a monster to target:
1. Monster 2 [HP: 7]
Select target (1-1): 1
Monster 2's defense has been reduced!
Joker cast Flame Thrower on Monster 2 for 43 damage!
Monster 2 has been defeated!
Heroes won the battle!
Batman earned 0 gold!
Joker earned 0 gold!
Batman earned 100 gold!
Joker earned 100 gold!
Heroes gained 4 experience and 200 gold!
M  C  C  X  C  X  M  M  
M  M  M  X  C  C  C  M  
C  M  C  C  C  M  C  C  
X  C  C  X  X  M  X  X  
C  X  C  X  M  M  M  C  
X  M  C  C  C  JO C  C  
C  M  C  C  C  X  M  BA 
M  C  C  M  C  M  M  M  
Enter move (W/A/S/D) or options (I/M/Q): 