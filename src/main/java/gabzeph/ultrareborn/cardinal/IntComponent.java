package gabzeph.ultrareborn.cardinal;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import net.minecraft.nbt.NbtCompound;

public interface IntComponent extends ComponentV3 {
    int getValue();
    void addWeek();
    void setWeek(int weeks);
}

class WeekComponent implements IntComponent {
    public int week = 1;

    @Override
    public int getValue() {
        return week;
    }

    @Override
    public void addWeek() {
        this.week = week + 1;
    }

    @Override
    public void setWeek(int weeks) {
        this.week = weeks;
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        this.week = tag.getInt("week");
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putInt("week", this.week);
    }
}
