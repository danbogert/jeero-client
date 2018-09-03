package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Connectivity {
    private final String rxBitrate;
    private final int score;
    private final int scoreBars;
    private final String signal;
    private final String signalAverage;

    public Connectivity(@JsonProperty("rx_bitrate") String rxBitrate,
                        @JsonProperty("score") int score,
                        @JsonProperty("score_bars") int scoreBars,
                        @JsonProperty("signal") String signal,
                        @JsonProperty("signal_avg") String signalAverage) {
        this.rxBitrate = rxBitrate;
        this.score = score;
        this.scoreBars = scoreBars;
        this.signal = signal;
        this.signalAverage = signalAverage;
    }

    public String getRxBitrate() {
        return rxBitrate;
    }

    public int getScore() {
        return score;
    }

    public int getScoreBars() {
        return scoreBars;
    }

    public String getSignal() {
        return signal;
    }

    public String getSignalAverage() {
        return signalAverage;
    }

    @Override
    public String toString() {
        return "{" +
                "rxBitrate='" + rxBitrate + '\'' +
                ", score=" + score +
                ", scoreBars=" + scoreBars +
                ", signal='" + signal + '\'' +
                ", signalAverage='" + signalAverage + '\'' +
                '}';
    }
}
