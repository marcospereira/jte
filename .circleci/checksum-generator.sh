#!/usr/bin/env bash

CHECKSUM_FILE="/tmp/checksum.txt"

find . -name "pom.xml" -print0 | while read -d $'\0' file; do
    echo "Adding $file to list of checksums"
    echo $(openssl dgst -sha256 "$file") >> "$CHECKSUM_FILE"
done

cat "$CHECKSUM_FILE"
