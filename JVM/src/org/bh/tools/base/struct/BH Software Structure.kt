package org.bh.tools.base.struct

/*
 * Copyright BHStudios ©2016 BH-1-PS. Made for Snek.
 *
 * @author Kyli Rouge
 * @since 2016-11-06
 */

/**
 * Represents a UI View in the Blue Husky Software Structure.
 *
 * See also: https://drive.google.com/file/d/0B9plORbvSu2rQlVBUTQteldSams/view?usp=sharing
 *
 * @param RepresentedType The type of object that this view can represent. This is required because all views should
 * contain no data, but instead directly represent them. For examples, an image view represents its image, a text view
 * represents its text, a menu might represent the array it presents, a slider would represent the value it
 * manipulates, an "OK" button represents the function that is called when it is pressed, etc.
 */
interface UIView<RepresentedType> {
    /**
     * The object that this view represents
     */
    var representedObject: RepresentedType // TODO: Reconsider whether this belongs in the view
}

/**
 * Represents a UI View Controller in the Blue Husky Software Structure.
 *
 * See also: https://drive.google.com/file/d/0B9plORbvSu2rQlVBUTQteldSams/view?usp=sharing
 */
interface UIViewController<out UIViewType : UIView<*>> {
    /**
     * The UI View that this UI View Controller controls
     */
    val view: UIViewType
}

/**
 * Represents a Data View Controller in the Blue Husky Software Structure.
 *
 * See also: https://drive.google.com/file/d/0B9plORbvSu2rQlVBUTQteldSams/view?usp=sharing
 */
interface DataViewController<out DataType : Data, out DataViewType : DataView<DataType>> {
    /**
     * The Data View that this Data View Controller controls
     */
    val dataView: DataViewType
}

/**
 * Represents a Data View in the Blue Husky Software Structure.
 *
 * See also: https://drive.google.com/file/d/0B9plORbvSu2rQlVBUTQteldSams/view?usp=sharing
 */
interface DataView<out DataType : Data> {
    /**
     * The Data that this Data View views
     */
    val data: DataType
}

/**
 * Represents Data in the Blue Husky Software Structure.
 *
 * See also: https://drive.google.com/file/d/0B9plORbvSu2rQlVBUTQteldSams/view?usp=sharing
 */
interface Data

/**
 * Represents a Data Accessor in the Blue Husky Software Structure.
 *
 * See also: https://drive.google.com/file/d/0B9plORbvSu2rQlVBUTQteldSams/view?usp=sharing
 */
interface DataAccessor<out DataType : Data, in AccessDetailType, out AccessStatusType> {
    /**
     * Accesses the data that this data accessor is meant to access
     *
     * @param details       Any details or instructions pertaining to how the data should be accessed
     * @param didAccessData The block that will be called once the data has been accessed.
     *                      - `accessedData` - The data that was accessed, or `null` if it couldn't be accessed
     *                      - `status`       - The status of the access. This may represent an error, metadata, etc.
     */
    fun accessData(details: AccessDetailType, didAccessData: (accessedData: DataType?, status: AccessStatusType) -> Unit)
}
