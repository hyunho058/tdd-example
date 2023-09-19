package com.example.tddexample.inflearn.algorithm_5_8;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public

class Care {

    public int orderNumber(int[] patients, int m) {
        Queue<Patient> patientQueue = new LinkedList<>();
        PriorityQueue<Integer> prioritySequenceQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < patients.length; i++) {
            patientQueue.offer(new Patient(patients[i], i));
            prioritySequenceQueue.offer(patients[i]);
        }

        int sequence = 0;

        while (!prioritySequenceQueue.isEmpty()) {
            int peek = prioritySequenceQueue.peek();
            Patient patient = patientQueue.poll();

            if (patient.isNotSameRisk(peek)) {
                patientQueue.offer(patient);
                continue;
            }

            prioritySequenceQueue.poll();
            sequence ++;

            if (patient.isSameSequence(m)) {
                break;
            }
        }

        return sequence;
    }

    static class Patient{
        private final int risk;
        private final int sequenceNumber;

        public Patient(int risk, int sequenceNumber) {
            this.risk = risk;
            this.sequenceNumber = sequenceNumber;
        }

        public boolean isNotSameRisk(int risk) {
            return this.risk != risk;
        }

        public boolean isSameSequence(int number) {
            return sequenceNumber == number;
        }
    }
}
