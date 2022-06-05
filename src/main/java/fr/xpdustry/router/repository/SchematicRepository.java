/*
 * Router, a Reddit-like Mindustry plugin for sharing schematics.
 *
 * Copyright (C) 2022 Xpdustry
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package fr.xpdustry.router.repository;

import com.j256.ormlite.dao.*;
import fr.xpdustry.router.model.*;
import java.io.*;
import java.util.*;
import org.jetbrains.annotations.*;

public interface SchematicRepository {

  static @NotNull SchematicRepository of(final String url, final @NotNull String username, final @NotNull String password) {
    return new SimpleSchematicRepository(url, username, password);
  }

  static @NotNull SchematicRepository of(final File file) {
    return new SimpleSchematicRepository("jdbc:sqlite:" + file.getAbsolutePath());
  }

  void saveSchematic(final @NotNull PlotSchematic schematic);

  @NotNull Optional<PlotSchematic> findSchematicById(final long id);

  @NotNull CloseableIterable<PlotSchematic> findAllSchematics();

  boolean existsSchematicById(final long id);

  long countSchematics();

  void deleteSchematicById(final long id);

  void deleteAllSchematics();
}
