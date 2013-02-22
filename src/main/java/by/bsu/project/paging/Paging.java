package by.bsu.project.paging;

import java.io.Serializable;

public class Paging implements Serializable {

    public static final int DEFAULT_PAGE_SIZE = 3;
    public static final int DEFAULT_MAX_LINKED_PAGES = 3;
    private int page = 0;
    private int pageCount;
    private boolean newPageSet;
    private int maxLinkedPages = DEFAULT_MAX_LINKED_PAGES;


    public Paging(int size) {
        setPageCount(size);
    }

    /**
     * Return the current page size.
     */
    public int getPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    /**
     * Set the current page number.
     * Page numbering starts with 0.
     */
    public void setPage(int page) {
        this.page = page;
        this.newPageSet = true;
    }

    /**
     * Return the current page number.
     * Page numbering starts with 0.
     */
    public int getPage() {
        this.newPageSet = false;
        if (this.page >= getPageCount()) {
            this.page = getPageCount() - 1;
        }
        return this.page;
    }

    /**
     * Set the maximum number of page links to a few pages around the current one.
     */
    public void setMaxLinkedPages(int maxLinkedPages) {
        this.maxLinkedPages = maxLinkedPages;
    }

    /**
     * Return the maximum number of page links to a few pages around the current one.
     */
    public int getMaxLinkedPages() {
        return this.maxLinkedPages;
    }


    /**
     * Return the number of pages for the current source list.
     */
    public int getPageCount() {
        float nrOfPages = (float) pageCount / getPageSize();
        return (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages);
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * Return if the current page is the first one.
     */
    public boolean isFirstPage() {
        return getPage() == 0;
    }

    /**
     * Return if the current page is the last one.
     */
    public boolean isLastPage() {
        return getPage() == getPageCount() - 1;
    }

    /**
     * Return the first page to which create a link around the current page.
     */
    public int getFirstLinkedPage() {
        return Math.max(0, getPage() - (getMaxLinkedPages() / 2));
    }

    /**
     * Return the last page to which create a link around the current page.
     */
    public int getLastLinkedPage() {
        return Math.min(getFirstLinkedPage() + getMaxLinkedPages() - 1, getPageCount() - 1);
    }
}