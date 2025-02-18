/*-
 * -\-\-
 * github-api
 * --
 * Copyright (C) 2016 - 2020 Spotify AB
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -/-/-
 */

package com.spotify.github.jackson;

import static java.util.Objects.isNull;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.spotify.github.v3.issues.Label;
import java.io.IOException;

class LabelSerializer extends StdSerializer<Label> {

  static final LabelSerializer INSTANCE = new LabelSerializer();

  private LabelSerializer() {
    super(Label.class);
  }

  @Override
  public void serialize(final Label value, final JsonGenerator gen, final SerializerProvider serializers)
      throws IOException {
    if (isNull(value)) {
      gen.writeNull();
    } else {
      serializers.defaultSerializeValue(value.name(), gen);
    }
  }
}
