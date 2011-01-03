package harvard.robobees.simbeeotic.model;


import harvard.robobees.simbeeotic.SimTime;
import org.w3c.dom.Document;


/**
 * An interface that establishes the core functionality of a model in the
 * simulation. A model need not be associated with a physical representation
 * in the world.
 *
 * @author bkate
 */
public interface Model {

    /**
     * Initializes the model before the simulation starts. This method
     * will be called exactly once by the simulation executive prior to
     * any call to {@link #processEvent(harvard.robobees.simbeeotic.SimTime , Event)}.
     * <p/>
     * The implementation cannot assume that all other models have been initialized,
     * so it is safer to perform actions that interact with other models from within
     * an event that is scheduled during the invocation of this method.
     */
    public void initialize();


    /**
     * This is the workhorse method of the model. When invoked by the sim executive
     * the model is to process the given event. It is up to the model to determine
     * the action to be taken based on the subtype of the event.
     *
     * Events are said to be executed instantaneously in time, meaning that no virtual
     * time passes while processing the event. Time is moved forward by processing
     * events in causal order.
     *
     * @param time The time at which the event is executed.
     * @param event The event to be executed.
     */
    public void processEvent(final SimTime time, final Event event);


    /**
     * Finalizes the model after the simulation has completed. This method will be
     * called exactly once, and no call to {@link #processEvent(harvard.robobees.simbeeotic.SimTime , Event)} will be made after this
     * method is invoked.
     */
    public void finish();


    /**
     * Sets the parent model of this model. This can only be done once, prior to initialization.
     *
     * @param parent The model that is the parent of this model.
     */
    public void setParentModel(Model parent);


    /**
     * Adds a child model to this model. Children can only be added prior to initialization.
     *
     * @param child The model that is assgned as a child of this model.
     */
    public void addChildModel(Model child);


    /**
     * Gets the optional XML configuration document, which may be embedded in the model's
     * configuration in the scenario document.
     *
     * @return doc The optional config document.
     */
    public Document getCustomConfig();


    /**
     * Sets the optional config doc.
     *
     * @param doc The document provided in the scenario config for this model.
     */
    public void setCustomConfig(Document doc);


    /**
     * Retrieves the unique model identifier assigned by the simulation executive
     * prior to initialization.
     *
     * @return An identifier in the range of (1, Integer.MAX_VALUE).
     */
    public int getModelId();


    /**
     * Gets the optional name of this model.
     *
     * @return The name of the model, which may be an empty string.
     */
    public String getName();
}
