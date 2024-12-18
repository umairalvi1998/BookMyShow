package com.bookmyshow.bookmyshow.Models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "shows")
@Getter
@Setter
public class Show extends BaseModel{
        @ManyToOne
        private Movie movie;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        @ManyToOne
        private Screen screen;
        @ElementCollection(targetClass = Features.class)
        private List<Features> features;

        public List<Features> getFeatures() {
                return features;
        }

        public void setFeatures(List<Features> features) {
                this.features = features;
        }

        public Screen getScreen() {
                return screen;
        }

        public void setScreen(Screen screen) {
                this.screen = screen;
        }

        public LocalDateTime getEndTime() {
                return endTime;
        }

        public void setEndTime(LocalDateTime endTime) {
                this.endTime = endTime;
        }

        public LocalDateTime getStartTime() {
                return startTime;
        }

        public void setStartTime(LocalDateTime startTime) {
                this.startTime = startTime;
        }

        public Movie getMovie() {
                return movie;
        }

        public void setMovie(Movie movie) {
                this.movie = movie;
        }
}
