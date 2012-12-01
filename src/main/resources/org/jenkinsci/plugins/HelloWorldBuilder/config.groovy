/*
 * This groovy script is used for per-project configuration.
 *
 * See global.groovy for a general discussion about groovy script.
 */
namespace(lib.FormTagLib).with {
    /*
     * Creates a text field that shows the value of the "name" property.
     * When submitted, it will be passed to the corresponding constructor parameter.
     */
    entry(title:'Name', field:'name') {
        textbox()
    }
}
