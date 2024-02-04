package com.drn.tinyurl.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RedirectCreationRequest {
    @NonNull
    private String alias;
    @NonNull
    private String url;
}
