/*
  Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.cj.api.xdevapi;

import com.mysql.cj.xdevapi.DbDoc;

/**
 * A statement representing a set of document modifications.
 */
public interface ModifyStatement extends Statement<ModifyStatement, Result> {
    /**
     * Add/replace the order specification for this statement.
     * 
     * @param sortFields
     *            sort expression
     * @return {@link ModifyStatement}
     */
    ModifyStatement sort(String... sortFields);

    /**
     * Add/replace the document limit for this statement.
     * 
     * @param numberOfRows
     *            limit
     * @return {@link ModifyStatement}
     */
    ModifyStatement limit(long numberOfRows);

    /**
     * Add an update to the statement setting the field as the document path to the given value for all documents matching the search criteria.
     * 
     * @param docPath
     *            document path to the given value
     * @param value
     *            value to set
     * @return {@link ModifyStatement}
     */
    ModifyStatement set(String docPath, Object value);

    /**
     * Add an update to the statement setting the field, if it exists at the document path, to the given value.
     * 
     * @param docPath
     *            document path to the given value
     * @param value
     *            value to set
     * @return {@link ModifyStatement}
     */
    ModifyStatement change(String docPath, Object value);

    /**
     * Nullify the given fields.
     * 
     * @param fields
     *            one or more field names
     * @return {@link ModifyStatement}
     */
    ModifyStatement unset(String... fields);

    /**
     * Unsupported.
     * 
     * @param document
     *            document
     * @return {@link ModifyStatement}
     */
    // TODO determine status of this feature
    ModifyStatement merge(String document);

    /**
     * Takes in a patch object and applies it on all documents matching the modify() filter, using the JSON_MERGE_PATCH() function.
     * 
     * @param document
     *            patch object
     * @return
     */
    ModifyStatement patch(DbDoc document);

    /**
     * Takes in a patch object and applies it on all documents matching the modify() filter, using the JSON_MERGE_PATCH() function.
     * 
     * @param document
     *            patch object
     * @return
     */
    ModifyStatement patch(String document);

    /**
     * Insert a value into the specified array.
     * 
     * @param field
     *            document path to the array field
     * @param value
     *            value to insert
     * @return {@link ModifyStatement}
     */
    ModifyStatement arrayInsert(String field, Object value);

    /**
     * Append a value to the specified array.
     * 
     * @param field
     *            document path to the array field
     * @param value
     *            value to append
     * @return {@link ModifyStatement}
     */
    ModifyStatement arrayAppend(String field, Object value);

    /**
     * Unsupported.
     * 
     * @param field
     *            document path to the array field
     * @param position
     *            array index
     * @return {@link ModifyStatement}
     */
    // TODO determine status of this feature
    ModifyStatement arrayDelete(String field, int position);
}
