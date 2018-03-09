public class StopWatch {

        private long start;
        private double elapsedTime;

        /**
         * Initializes a new stopwatch.
         */
        public StopWatch() {
        }

        private void stop(){

        }

        public void start(){
            start = System.currentTimeMillis();
        }

        /**
         * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
         *
         * @return elapsed CPU time (in seconds) since the stopwatch was created
         */
        public double elapsedTime() {
            long now = System.currentTimeMillis();
            elapsedTime = (now - start) / 1000.0;
            return elapsedTime;
        }

    @Override
    public String toString() {
        return  elapsedTime + "";
    }
}

