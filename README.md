# 1. FileStatus Collection
```
// Stores overall file processing status
{
  "_id": ObjectId("..."),
  "fileId": "2024-03-01-promotions-batch-123",     // Unique identifier for the file
  "s3Bucket": "marketing-promotion-files",         // S3 bucket name
  "s3Key": "incoming/march2024/promo_batch_123.csv", // S3 object key
  "fileName": "promo_batch_123.csv",               // Original filename
  "contentType": "text/csv",                       // File content type
  "fileSize": 25678901,                            // File size in bytes
  "estimatedRecordCount": 1500000,                 // Estimated total records in file
  "chunkSize": 50000,                              // Number of records per chunk
  "chunkingStrategy": "FIXED_COUNT",               // How the file was chunked
  "totalChunks": 30,                               // Total number of chunks
  "status": "IN_PROGRESS",                         // Overall status (PENDING, IN_PROGRESS, COMPLETED, FAILED)
  "createdAt": ISODate("2024-03-01T12:00:00Z"),    // When file was first received
  "processingStartedAt": ISODate("2024-03-01T12:01:30Z"), // When processing began
  "completedAt": null,                             // When processing finished
  "lastUpdatedAt": ISODate("2024-03-01T12:10:15Z"), // Last status update
  "errorDetails": null,                            // Overall error info if failed
  "metadata": {                                    // Optional file metadata
    "source": "campaign-manager",
    "campaignId": "spring-promo-2024",
    "priority": "high"
  },
  "processingStats": {                             // Processing statistics
    "completedChunks": 15,
    "failedChunks": 2,
    "inProgressChunks": 3,
    "pendingChunks": 10,
    "successRate": 98.5                            // Percentage of successfully processed records
  }
}
```

# 2 .ChunkStatus Collection
```
// Stores processing status for each chunk
{
  "_id": ObjectId("..."),
  "chunkId": "2024-03-01-promotions-batch-123-chunk-5", // Unique chunk identifier
  "fileId": "2024-03-01-promotions-batch-123",         // Reference to parent file
  "chunkIndex": 5,                                     // Position in file (zero-based)
  "startOffset": 250000,                               // Starting record index
  "endOffset": 299999,                                 // Ending record index
  "recordCount": 50000,                                // Records in this chunk
  "status": "COMPLETED",                               // Status (PENDING, IN_PROGRESS, COMPLETED, FAILED)
  "processingThread": "worker-node-3-thread-7",        // Thread/process identifier
  "startedAt": ISODate("2024-03-01T12:05:42Z"),        // Processing start time
  "completedAt": ISODate("2024-03-01T12:06:15Z"),      // Completion time
  "duration": 33,                                      // Processing duration in seconds
  "retryCount": 0,                                     // Number of retry attempts
  "errorDetails": null,                                // Error information if failed
  "processingStats": {                                 // Summary statistics only
    "successfulRecords": 49850,
    "failedRecords": 150,
    "successRate": 99.7                                // Percentage successful
  },
  "errorSummary": {                                    // Aggregated error information
    "validation": {
      "invalidUserId": 35,
      "invalidPromoCode": 42,
      "expiredOffer": 28
    },
    "processing": {
      "kafkaPublishFailure": 45
    }
  }
}
```
