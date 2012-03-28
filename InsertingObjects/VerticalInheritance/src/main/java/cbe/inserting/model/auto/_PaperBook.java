package cbe.inserting.model.auto;

import cbe.inserting.constants.PaperBookFormat;
import cbe.inserting.model.Book;

/**
 * Class _PaperBook was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _PaperBook extends Book {

    public static final String FORMAT_PROPERTY = "format";

    public static final String ID_PK_COLUMN = "id";

    public void setFormat(PaperBookFormat format) {
        writeProperty("format", format);
    }
    public PaperBookFormat getFormat() {
        return (PaperBookFormat)readProperty("format");
    }

}
