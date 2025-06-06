package exoplanet;

public class Exoplanet {
	private String planetName;
	private String hostStarName;
	private double distance;
	private double mass;
	private String detectionMethod;

	public Exoplanet(String planetName, String hostStarName, double distance, double mass, String detectionMethod) {
		this.planetName = planetName;
		this.hostStarName = hostStarName;
		this.distance = distance;
		this.mass = mass;
		this.detectionMethod = detectionMethod;
	}

	public String toString() {
		return String.format("%s orbiting %s | Distance: %.2f ly | Mass: %.2f Mj | Detected by: %s", planetName,
				hostStarName, distance, mass, detectionMethod);
	}
}
