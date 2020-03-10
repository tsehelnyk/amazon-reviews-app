package com.dev.boot.amazonreviewsapp.util;

import com.dev.boot.amazonreviewsapp.entity.model.Review;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

@Component
public class CsvToObjectsListConverter {
    private static final String[] HEADERS =
            {"Id", "ProductId", "UserId", "ProfileName", "HelpfulnessNumerator",
                    "HelpfulnessDenominator", "Score", "Time", "Summary", "Text"};

    public List<Review> convert(String file) throws IOException {
        try (Reader reader = new FileReader(file)) {
            List<CSVRecord> records = CSVFormat.DEFAULT
                    .withHeader(HEADERS)
                    .withFirstRecordAsHeader()
                    .parse(reader)
                    .getRecords();
            return records.stream().map(this::toReview).collect(Collectors.toList());
        }
    }

    private Review toReview(CSVRecord record) {
        Review review = new Review();
        review.setProductId(record.get("ProductId"));
        review.setUserId(record.get("UserId"));
        review.setProfileName(record.get("ProfileName"));
        review.setHelpfulnessNominator(Integer.parseInt(record.get("HelpfulnessNumerator")));
        review.setHelpfulnessDenominator(Integer.parseInt(record.get("HelpfulnessDenominator")));
        review.setScore(Integer.parseInt(record.get("Score")));
        review.setTime(Long.parseLong(record.get("HelpfulnessDenominator")));
        review.setSummary(record.get("Summary"));
        review.setText(record.get("Text"));
        return review;
    }

}
