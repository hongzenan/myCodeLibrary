package ze.nan.hong.practices.fanxing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


interface Factory<T> {
    T create();
}

class ForExtends {
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

class Filter extends ForExtends {}
class FuelFilter extends Filter {
    public static class Factory implements ze.nan.hong.practices.fanxing.Factory<FuelFilter> {
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}
class AirFilter extends Filter {
    public static class Factory implements ze.nan.hong.practices.fanxing.Factory<AirFilter> {
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class Belt extends ForExtends {
}
class FanBelt extends Belt {
    public static class Factory implements ze.nan.hong.practices.fanxing.Factory<FanBelt> {
        public FanBelt create() {
            return new FanBelt();
        }
    }
}
class GeneratorBelt extends Belt {
    public static class Factory implements ze.nan.hong.practices.fanxing.Factory<GeneratorBelt> {
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}


class Part {
    static List<Factory<? extends ForExtends>> partFactories = new ArrayList<>();
    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }

    private static Random rand = new Random(47);
    public static ForExtends createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

public class FactoryModel {
    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            System.out.println(Part.createRandom());
        }
    }
}
