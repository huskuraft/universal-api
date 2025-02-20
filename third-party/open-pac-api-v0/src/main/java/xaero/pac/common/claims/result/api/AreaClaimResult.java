package xaero.pac.common.claims.result.api;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

/**
 * A claim action result for an area of chunks
 */
public class AreaClaimResult {

    private final List<ClaimResult.Type> resultTypes;
    private final int left;
    private final int top;
    private final int right;
    private final int bottom;

    /**
     * A constructor for internal usage
     *
     * @param resultTypes a set of all resul types
     * @param left        lowest X coordinate value in this area
     * @param top         lowest Z coordinate value in this area
     * @param right       highest X coordinate value in this area
     * @param bottom      highest Z coordinate value in this area
     */
    public AreaClaimResult(Set<ClaimResult.Type> resultTypes, int left, int top, int right, int bottom) {
        super();
        List<ClaimResult.Type> resultTypeList = Arrays.asList(resultTypes.toArray(new ClaimResult.Type[resultTypes.size()]));
        Collections.sort(resultTypeList);
        this.resultTypes = Collections.unmodifiableList(resultTypeList);
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    /**
     * Gets the number of result types ({@link ClaimResult.Type}).
     *
     * @return the number of result types
     */
    public int getSize() {
        return resultTypes.size();
    }

    /**
     * Gets the result type ({@link ClaimResult.Type}) iterable.
     *
     * @return the result type iterable, not null
     */
    @Nonnull
    public Iterable<ClaimResult.Type> getResultTypesIterable() {
        return resultTypes;
    }

    /**
     * Gets a stream of all result types ({@link ClaimResult.Type}).
     *
     * @return the result type stream, not null
     */
    @Nonnull
    public Stream<ClaimResult.Type> getResultTypesStream() {
        return resultTypes.stream();
    }

    /**
     * Get the lowest X coordinate value in this area.
     *
     * @return the lower X value in the area
     */
    public int getLeft() {
        return left;
    }

    /**
     * Get the lowest Z coordinate value in this area.
     *
     * @return the lower z value in the area
     */
    public int getTop() {
        return top;
    }

    /**
     * Get the highest X coordinate value in this area.
     *
     * @return the highest X value in the area
     */
    public int getRight() {
        return right;
    }

    /**
     * Get the highest Z coordinate value in this area.
     *
     * @return the highest Z value in the area
     */
    public int getBottom() {
        return bottom;
    }

}
