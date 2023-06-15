package info3.game.modele;

import automate.Category;
import automate.EnumCategory;
import automate.EnumDirection;

public abstract class MoveableEntity extends Entity{
	protected int attackCoeff;
	protected int lifePoint;
	protected int speedCoeff;
	EnumDirection facing;

	public MoveableEntity(int lifePoint, int attackCoeff,int speedCoeff) {
		super();
		this.lifePoint = lifePoint;
		this.attackCoeff = attackCoeff;
		this.speedCoeff = speedCoeff;
	}

	public abstract void takeDamage(int damage);
	
	public abstract boolean closeTo(EnumDirection d, EnumCategory c);
	
	public abstract boolean closest(EnumDirection d, EnumCategory c);
	
	public abstract boolean gotStuff();
	
	public abstract boolean cell(EnumDirection d, EnumCategory c);
	
	public abstract void hit(EnumDirection d, EnumCategory c);
	
	
	public boolean gotPower() {
		return lifePoint <= 0;
	}

	public void die() {
		GameModele.entities.remove(this);
	}

	public int getLifePoint() {
		return lifePoint;
	}


	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
	}


	public int getAttackCoeff() {
		return attackCoeff;
	}


	public void setAttackCoeff(int attackCoeff) {
		this.attackCoeff = attackCoeff;
	}


	public int getSpeedCoeff() {
		return speedCoeff;
	}


	public void setSpeedCoeff(int speedCoeff) {
		this.speedCoeff = speedCoeff;
	}


	public EnumDirection getFacing() {
		return facing;
	}


	public void setFacing(EnumDirection facing) {
		this.facing = facing;
	}
	
	//public abstract void move(EnumDirection eval);
	
}
