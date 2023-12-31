package info3.game.modele.MoveableEntityClass;

import automate.AutomateLoader;
import info3.game.modele.GameEntity;
import info3.game.modele.GameModele;
import info3.game.modele.map.Tiles;
import info3.game.vue.avatar.Avatar;
import info3.game.vue.avatar.CrabKingAvatar;

public class CrabKing extends Crab {

	public static int NB_CRABS = 3;
	private int level;

	private int crabsRemaining;
	private boolean spawnable;
	private int tranche;
	private int statEgg;

	public CrabKing(int level, int lifePoint, int x, int y, int damage) {
		super(level, null, x, y);
		this.level = level;
		this.m_healthPoints = lifePoint;
		statEgg = m_healthPoints / 5;
		this.m_damage = damage;
		spawnable = true;
		tranche = m_healthPoints - statEgg;
		crabsRemaining = NB_CRABS;
		this.automate = AutomateLoader.findAutomate(GameEntity.CrabKing);
		this.current_state = automate.initial_state;
		this.setAvatar(new CrabKingAvatar(this, level));
	}

	public boolean gotStuff() {
		return spawnable;
	}

	public void die() {
		GameModele.map.openKraken();
	}

	@Override
	public void takeDamage(int damage) {
		super.takeDamage(damage);
		if (m_healthPoints <= tranche) {
			spawnable = true;
			tranche = tranche - statEgg;
		}
	}

	public void egg() {
		int egged = 0;
		while (egged < NB_CRABS) {
			if (this.tick(this.timeElapsed) % 700 == 0) {
				Crab b = null;
				Tiles t;
				switch (GameModele.player1.facing) {
				case N:
					t = GameModele.map.getTileUnderEntity(x, y - 5);
					if (t.isIsland()) {
						b = new Crab(level, null, t.getX(), t.getY());
					}
					break;
				case S:
					t = GameModele.map.getTileUnderEntity(x, y + 5);
					if (t.isIsland()) {
						b = new Crab(level, null, t.getX(), t.getY());
					}
					break;
				case E:
					t = GameModele.map.getTileUnderEntity(x + 5, y);
					if (t.isIsland()) {
						b = new Crab(level, null, t.getX(), t.getY());
					}
					break;
				case W:
					t = GameModele.map.getTileUnderEntity(x - 5, y);
					if (t.isIsland()) {
						b = new Crab(level, null, t.getX(), t.getY());
					}
					break;
				case NW:
					t = GameModele.map.getTileUnderEntity(x - 5, y - 5);
					if (t.isIsland()) {
						b = new Crab(level, null, t.getX(), t.getY());
					}
					break;
				case NE:
					t = GameModele.map.getTileUnderEntity(x + 5, y - 5);
					if (t.isIsland()) {
						b = new Crab(level, null, t.getX(), t.getY());
					}
					break;
				case SW:
					t = GameModele.map.getTileUnderEntity(x - 5, y + 5);
					if (t.isIsland()) {
						b = new Crab(level, null, t.getX(), t.getY());
					}
					break;
				case SE:
					t = GameModele.map.getTileUnderEntity(x + 5, y + 5);
					if (t.isIsland()) {
						b = new Crab(level, null, t.getX(), t.getY());
					}
					break;
				default:
					t = GameModele.map.getTileUnderEntity(x + 5, y + 5);
					for (int i = 6, j = 6; i < 15 && j < 15 && !t.isIsland(); i++, j++) {
						t = GameModele.map.getTileUnderEntity(x + i, y + j);
					}
					b = new Crab(level, null, t.getX(), t.getY());
					break;
				}
				if (b != null) {
					GameModele.entities.add(b);
					egged++;
				}
			}
		}
		spawnable = false;
	}

	public int getCenterX() {
		return this.x - ((this.avatar.getWidth() / Avatar.SCALE_IMG) / 2);
	}

	public int getCenterY() {
		return this.y + (this.avatar.getHeight() / Avatar.SCALE_IMG);
	}

}
