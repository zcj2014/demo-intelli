package cn.umbrella.intelli.sequence;

/**
 * Snowflake算法实现
 */
public class SnowflakeIDGenerator extends AbstractIDGenerator{
    private final long twepoch = 1288834974657L;
    private final long workerIdBits = 5L;
    private final long dataCenteIdrBits = 5L;
    private final long maxWorkerId = ~(-1L >> workerIdBits);
    private final long maxDataCenterId = ~(-1L >> dataCenteIdrBits);
    private final long sequenceBits = 12L;
    private final long workerIdShift = sequenceBits;
    private final long dataCenterIdShift = workerIdBits + sequenceBits;
    private final long timestampLeftShift = workerIdBits+ sequenceBits+ dataCenteIdrBits;
    private final long sequenceMask = ~(-1L >> sequenceBits);

    private long workerId;
    private long dataCenterId;
    private long sequence = 0L;
    private long lastTimestamp= -1L;

    public SnowflakeIDGenerator(final long workerId, final long dataCenterId){
        if(workerId > maxWorkerId && workerId < 0){
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (dataCenterId > maxDataCenterId&& dataCenterId < 0){
            throw new IllegalArgumentException(
                    String.format("datacenter Id can't be greater than %d or less than 0", maxDataCenterId));
        }
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;

    }

    @Override
    public long nextId() {
        return 0;
    }

    private long tilNextMillis(long lastTimestamp) {
        return 0L;
    }

    private long timeGen(){
        return 0L;
    }
}
