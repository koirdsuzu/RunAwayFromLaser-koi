package net.kunmc.lab.runawayfromlaser.laser;

import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

class GenerateLaserTask extends BukkitRunnable {
    private final Laser laser;

    GenerateLaserTask(Laser laser) {
        this.laser = laser;
    }

    @Override
    public void run() {
        if (laser.isInvisible) {
            return;
        }
        
        for (double z = -2; z < laser.length + 2; z += laser.gap) {
            laser.origin.getWorld().spawnParticle(Particle.REDSTONE,
                    laser.origin.getX(), laser.origin.getY(), laser.origin.getZ() + z,
                    1, 0, 0, 0, 0, new Particle.DustOptions(Color.RED, laser.size));
        }
    }
}
