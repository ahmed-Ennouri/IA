package org.ia.pharmacies.models;

import java.util.Objects;

public class Pharmacie implements Comparable<Pharmacie> {
	private String name;
	private double x, y;

	public Pharmacie(String name, double x, double y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pharmacie [name=" + name + ", x=" + x + ", y=" + y + "]";
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		Pharmacie aStarNode = (Pharmacie) other;
		return Objects.equals(name, aStarNode.name);
	}

	@Override
	public int compareTo(Pharmacie other) {
		return name.compareTo(other.name);
	}

}
