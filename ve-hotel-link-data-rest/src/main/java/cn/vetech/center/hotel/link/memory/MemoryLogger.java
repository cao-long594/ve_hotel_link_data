package cn.vetech.center.hotel.link.memory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;

@Component
public class MemoryLogger implements ApplicationListener<ContextClosedEvent> {

    private final static Logger logger = LoggerFactory.getLogger(MemoryLogger.class);

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        printJvmInfo();
        printDetailedJvmInfo();
    }

    public void printJvmInfo() {
        Runtime runtime = Runtime.getRuntime();
        logger.info("Available Processors: {}", runtime.availableProcessors());
        logger.info("Free Memory: {} bytes", runtime.freeMemory());
        logger.info("Total Memory: {} bytes", runtime.totalMemory());
        logger.info("Max Memory: {} bytes", runtime.maxMemory());
    }

    public void printDetailedJvmInfo() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        logger.info("Heap Memory Usage: {}", memoryMXBean.getHeapMemoryUsage());
        logger.info("Non-Heap Memory Usage: {}", memoryMXBean.getNonHeapMemoryUsage());
        logger.info("Thread Count: {}", threadMXBean.getThreadCount());
        logger.info("Peak Thread Count: {}", threadMXBean.getPeakThreadCount());
        logger.info("Total Started Thread Count: {}", threadMXBean.getTotalStartedThreadCount());
    }
}