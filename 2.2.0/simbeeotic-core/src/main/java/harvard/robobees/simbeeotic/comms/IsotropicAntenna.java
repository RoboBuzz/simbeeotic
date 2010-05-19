package harvard.robobees.simbeeotic.comms;


/**
 * A theoretical isotropic antenna that radiates/receives power evenly over
 * a 3-dimensional space.
 *
 * @author bkate
 */
public class IsotropicAntenna implements AntennaPattern {

    /**
     * {@inheritDoc}
     *
     * This antenna will always return {@code 0 dBi} for any orientation.
     */
    @Override
    public double getPower(double azimuth, double elevation) {
        return 0;
    }
}
